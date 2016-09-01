package com.santaclaus.presents.dao;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.ChocolateCandy;
import com.santaclaus.presents.candies.ChocolateCandyWithFilling;
import com.santaclaus.presents.candies.LollipopCandy;
import com.santaclaus.presents.candies.LollipopCandyWithFilling;
import com.santaclaus.presents.db.InsertQuery;
import com.santaclaus.presents.db.Query;
import java.util.List;


public class CandyDAOImpl implements CandyDAO {
    
    private static final String CHOCO_CANDY = "chocolate";
    private static final String CHOCO_CANDY_WITH_FILLING = "chocolateWithFilling";
    private static final String LOLLIPOP_CANDY = "lollipop";
    private static final String LOLLIPOP_CANDY_WITH_FILLING = "lollipopWithFilling";

    @Override
    public void addCandies(int presentId, List<AbstractCandy> candies){
        
        for (AbstractCandy candy : candies){
            
            String type = candy.getType();
            String name = candy.getName();
            double weight = candy.getWeight();
            double price = candy.getPrice();
            String tasteType = null;
            String chocoType = null;
            String fillingType = null;
                        
            if (type.equals(LOLLIPOP_CANDY)){
                LollipopCandy lollipopCandy = (LollipopCandy) candy;
                tasteType = lollipopCandy.getTasteType().toString();
            }
            else if (type.equals(LOLLIPOP_CANDY_WITH_FILLING)){
                LollipopCandyWithFilling lollipopCandyWithFilling = (LollipopCandyWithFilling) candy;
                tasteType = lollipopCandyWithFilling.getTasteType().toString();
                fillingType = lollipopCandyWithFilling.getFillingType().toString();
            }
            else if (type.equals(CHOCO_CANDY)){
                ChocolateCandy chocolateCandy = (ChocolateCandy) candy;
                chocoType = chocolateCandy.getChocoType().toString();
            }
            else if (type.equals(CHOCO_CANDY_WITH_FILLING)){
                ChocolateCandyWithFilling chocolateCandyWithFilling = (ChocolateCandyWithFilling) candy;
                chocoType = chocolateCandyWithFilling.getChocoType().toString();
                fillingType = chocolateCandyWithFilling.getFillingType().toString();
            }
            else {
                throw new IllegalArgumentException("'"+type+"' is incorrect CANDY TYPE");
            }            
            
            String queryString = "INSERT INTO candy (present_id, type, name, weight, price, taste_type, choco_type, filling_type) VALUES"
                            + " ("+presentId+", '"+type+"', '"+name+"', "+weight+", "+price+", '"+tasteType+"', '"+chocoType+"', '"+fillingType+"')";
            Query query = new InsertQuery(queryString);
            System.out.println(queryString);
            query.execute();
            query.close();
        }
        
    }
    
}
