package com.santaclaus.presents.web.controllers;

import com.santaclaus.presents.dao.DAOFactory;
import com.santaclaus.presents.dao.PresentDAO;
import com.santaclaus.presents.present.Present;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String render(@ModelAttribute("present") Present present, 
                         @ModelAttribute("uploadMessage") String uploadMessage,
                         Model model)
    {  
        
        PresentDAO presentDAO = DAOFactory.INSTANCE.getPresentDAO();        
        List<Integer> presentsId = presentDAO.getAllPresentsId();
        
        model.addAttribute("presentsId", presentsId);
        model.addAttribute("present", present);
        model.addAttribute("uploadMessage", uploadMessage);
        
        return "home";
    }
    
}
