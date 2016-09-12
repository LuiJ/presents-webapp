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
    public int save(Present present){        
        int newPresentId = helper.save(present); 
        List<AbstractCandy> candies = present.getCandies();
        
        if (!candies.isEmpty()){
            for (AbstractCandy candy : candies){
                candy.setPresentId(newPresentId);
                candyDAO.save(candy);
            }
        }        
        return newPresentId;        
    }    
    
    
    @Override
    public Present getById(int id){        
        Present present = helper.getById(id);
        List<AbstractCandy> candies = candyDAO.getByPresentId(id);
        
        for (AbstractCandy candy : candies){
            present.addCandy(candy);
        } 
        return present;
    }    
    
    
    @Override
    public List<Present> getAll(){        
        List<Present> presents = helper.getAll();        
        return presents;        
    }
    
}
