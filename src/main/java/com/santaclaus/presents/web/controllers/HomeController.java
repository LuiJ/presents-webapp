package com.santaclaus.presents.web.controllers;

import com.santaclaus.presents.dao.DAOFactory;
import com.santaclaus.presents.dao.PresentDAO;
import com.santaclaus.presents.present.Present;
import java.util.ArrayList;
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
        List<Present> presents = presentDAO.getAll();
        List<Integer> presentsId = new ArrayList<>();
        
        for (Present p : presents){
            int presentId = p.getId();
            presentsId.add(presentId);
        }
        
        model.addAttribute("presentsId", presentsId);
        model.addAttribute("present", present);
        model.addAttribute("uploadMessage", uploadMessage);
        
        return "home";
    }
    
}
