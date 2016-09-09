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
        if (id != 0){
            PresentDAO presentDAO = DAOFactory.INSTANCE.getPresentDAO();
            Present present = presentDAO.getPresentById(id);
            redirectAttributes.addFlashAttribute("present", present);
        }        
        return "redirect:/";
    } 
    
    
    
    @RequestMapping(method = RequestMethod.POST, 
                    headers = "content-type=multipart/form-data")
    public String addPresent(@RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes)
    {
        StringBuilder uploadMessage = new StringBuilder();
        if (!file.isEmpty()){
            String fileType = file.getContentType();
            if (FILE_TYPE.equalsIgnoreCase(fileType)){
                Present present = createPresent(file, uploadMessage);
                if (present != null){
                    try {
                        PresentDAO presentDAO = DAOFactory.INSTANCE.getPresentDAO();
                        int newPresentId = presentDAO.addPresent(present);
                        uploadMessage.append("INFO: Present has been sucessfully added. Present ID = "+newPresentId);
                    }
                    catch (Exception e){
                        uploadMessage.append("ERROR: DataBase error. Please, contact support :)");
                    }
                } 
            }
            else {
                uploadMessage.append("ERROR: Incorrect file uploaded");
            }
        }        
        redirectAttributes.addFlashAttribute("uploadMessage", uploadMessage);
        return "redirect:/";
    }
    
    
    private Present createPresent(MultipartFile file, StringBuilder uploadMessage)
    {
        InputStream xmlFile = null;
        Present present = null;
        
        try {
            xmlFile = file.getInputStream();
        }                
        catch (IOException e){
            uploadMessage.append("ERROR: File processing failed. Try again, please.");
        }                

        if (xmlFile != null){            
            try {
                PresentCreator presentCreator = new PresentCreatorXml(xmlFile);
                present = presentCreator.create();
            }
            catch (Exception e){
                uploadMessage.append("ERROR: Incorrect XML file uploaded");
            }    
        }        
        return present;
    }
    
}
