package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CandyFactory {
    
    private static final String CANDY_TYPE = "candy.type";
    private static final String CHOCO_CANDY = "chocolate";
    private static final String CHOCO_CANDY_WITH_FILLING = "chocolateWithFilling";
    private static final String LOLLIPOP_CANDY = "lollipop";
    private static final String LOLLIPOP_CANDY_WITH_FILLING = "lollipopWithFilling";

    private static AbstractCandyBuilder builder;
    
    public static AbstractCandy create(ResultSet candyResultSet) 
            throws SQLException {
        
        AbstractCandy candy = null;
        String candyType = candyResultSet.getString(CANDY_TYPE);
        
        if (candyType.equals(CHOCO_CANDY)){
            builder = new ChocolateCandyBuilder();
        }
        else if (candyType.equals(CHOCO_CANDY_WITH_FILLING)){
            builder = new ChocolateCandyWithFillingBuilder();
        }
        else if (candyType.equals(LOLLIPOP_CANDY)){
            builder = new LollipopCandyBuilder();
        }
        else if (candyType.equals(LOLLIPOP_CANDY_WITH_FILLING)){
            builder = new LollipopCandyWithFillingBuilder();
        }
        else {
            throw new IllegalArgumentException("'"+candyType+"' is incorrect CANDY TYPE");
        }
        
        candy = builder.build(candyResultSet);
        
        return candy;
        
    }   
    
}
