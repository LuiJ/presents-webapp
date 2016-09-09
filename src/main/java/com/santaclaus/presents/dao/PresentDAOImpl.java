package com.santaclaus.presents.dao;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.present.Present;
import java.util.List;


public class PresentDAOImpl implements PresentDAO {
    
    private DAOHelper<Present> helper;
    private CandyDAO candyDAO;
    
    public PresentDAOImpl(){
        helper = new DAOHelper<>(Present.class); 
        candyDAO = DAOFactory.INSTANCE.getCandyDAO();
    }

    
    @Override
    public int addPresent(Present present){        
        int newPresentId = helper.save(present); 
        List<AbstractCandy> candies = present.getCandies();
        
        if (!candies.isEmpty()){
            candyDAO.addCandies(newPresentId, candies);
        }        
        return newPresentId;        
    }    
    
    
    @Override
    public Present getPresentById(int id){        
        Present present = helper.getById(id);
        List<AbstractCandy> candies = candyDAO.getCandiesByPresentId(id);
        
        for (AbstractCandy candy : candies){
            present.addCandy(candy);
        } 
        return present;
    }    
    
    
    @Override
    public List<Present> getAllPresents(){        
        List<Present> presents = helper.getAll();        
        return presents;        
    }
    
}
