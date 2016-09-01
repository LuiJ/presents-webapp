package com.santaclaus.presents.dao;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.db.InsertQuery;
import com.santaclaus.presents.db.Query;
import com.santaclaus.presents.db.SelectQuery;
import com.santaclaus.presents.parser.resultset.CandyFactory;
import com.santaclaus.presents.present.Present;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PresentDAOImpl implements PresentDAO {

    @Override
    public int addPresent(Present present){
        
        String name = present.getName();
        List<AbstractCandy> candies = present.getCandies();
        String queryString = "INSERT INTO present (name) VALUES ('"+name+"')";
        System.out.println(queryString);
        Query query = new InsertQuery(queryString);
        ResultSet resultSet = query.execute();
        int newPresentId = -1;
        
        try {  
            if (resultSet.next()){
                newPresentId = resultSet.getInt(1);
                CandyDAO candyDAO = DAOFactory.INSTANCE.getCandyDAO();
                candyDAO.addCandies(newPresentId, candies);
            }            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            query.close();
        }
        
        return newPresentId;        
    }
    
    
    @Override
    public Present getPresentById(int id){
        
        Present present = new Present();
        String queryString = "SELECT * FROM present JOIN candy ON candy.present_id = present.id WHERE present.id = "+id;  
        System.out.println(queryString);  
        Query query = new SelectQuery(queryString); 
        ResultSet resultSet = query.execute();        
         
        try {  
            while (resultSet.next()){
                if (present.getId() == 0 && present.getName() == null){
                    int presentId = resultSet.getInt(Present.FIELD_ID);
                    present.setId(presentId);
                    String presentName = resultSet.getString(Present.FIELD_NAME);
                    present.setName(presentName);
                }
                AbstractCandy candy = CandyFactory.create(resultSet);
                present.addCandy(candy);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            query.close();
        }
        
        return present;
    }
    
    
    @Override
    public List<Integer> getAllPresentsId(){
        
        List<Integer> presentsId = new ArrayList<Integer>();        
        String queryString = "SELECT id FROM present";   
        System.out.println(queryString); 
        Query query = new SelectQuery(queryString);        
        ResultSet resultSet = query.execute();        
         
        try {  
            while (resultSet.next()){
                presentsId.add(resultSet.getInt(1));
            }            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            query.close();
        }
        
        return presentsId;
        
    }
    
}
