package com.santaclaus.presents.dao;

import com.santaclaus.presents.candies.AbstractCandy;
import java.util.List;
import java.util.Properties;


public class CandyDAOImpl implements CandyDAO {
    
    private DAOHelper<AbstractCandy> helper;
    
    public CandyDAOImpl(){
        helper = new DAOHelper<>(AbstractCandy.class); 
    }

    @Override
    public void save(AbstractCandy candy){ 
        helper.save(candy);
    }
    
    @Override
    public List<AbstractCandy> getByPresentId(int presentId){
        String id = String.valueOf(presentId);
        Properties conditions = new Properties();
        conditions.put("present_id", id);
        List<AbstractCandy> candies = helper.getAllByConditions(conditions);
        return candies;
    }
    
}
