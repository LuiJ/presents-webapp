package com.santaclaus.presents.web.controllers;

import com.santaclaus.presents.creator.PresentCreator;
import com.santaclaus.presents.creator.PresentCreatorXml;
import com.santaclaus.presents.dao.DAOFactory;
import com.santaclaus.presents.dao.PresentDAO;
import com.santaclaus.presents.present.Present;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/presents")
public class PresentsController {
    
    private static final String FILE_TYPE = "text/xml";

    
    @RequestMapping(method = RequestMethod.GET)
    public String getPresentById(@RequestParam("id") int id, 
                                 RedirectAttributes redirectAttributes)
    {
        PresentDAO presentDAO = DAOFactory.INSTANCE.getPresentDAO();
        Present present = presentDAO.getPresentById(id);
        
        redirectAttributes.addFlashAttribute("present", present);
        return "redirect:/";
    } 
    
    
    
    @RequestMapping(method = RequestMethod.POST, 
                    headers = "content-type=multipart/form-data")
    public String addPresent(@RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes)
    {
        String uploadMessage = null;
        if (!file.isEmpty()){
            String fileType = file.getContentType();
            if (FILE_TYPE.equalsIgnoreCase(fileType)){
                
                InputStream xmlFile = null; //в отдельный метод
                try {
                    xmlFile = file.getInputStream();
                }                
                catch (IOException e){
                    uploadMessage = "ERROR: File processing failed. Try again, please.";
                }                
                
                if (xmlFile != null){
                    
                    Present present = null;
                    try {
                        PresentCreator presentCreator = new PresentCreatorXml(xmlFile);
                        present = presentCreator.create();
                    }
                    catch (Exception e){
                        uploadMessage = "ERROR: Incorrect XML file uploaded";
                    }

                    //--------
                    
                    if (present != null){
                        
                        try {
                            PresentDAO presentDAO = DAOFactory.INSTANCE.getPresentDAO();
                            int newPresentId = presentDAO.addPresent(present);
                            uploadMessage = "INFO: Present has been sucessfully added. Present ID = "+newPresentId;
                        }
                        catch (Exception e){
                            uploadMessage = "ERROR: DataBase error. Please, contact support :)";
                        }
                    }                    
                }
            }
            else {
                uploadMessage = "ERROR: Incorrect file uploaded";
            }
        }        
        redirectAttributes.addFlashAttribute("uploadMessage", uploadMessage);
        return "redirect:/";
    }
    
}
