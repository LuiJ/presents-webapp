package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.Identifiable;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CandyBuilder implements EntityBuilder {
    
    private static final String CANDY_TYPE = "type";
    private static final String CHOCO_CANDY = "ChocolateCandy";
    private static final String CHOCO_CANDY_WITH_FILLING = "ChocolateCandyWithFilling";
    private static final String LOLLIPOP_CANDY = "LollipopCandy";
    private static final String LOLLIPOP_CANDY_WITH_FILLING = "LollipopCandyWithFilling";

    private AbstractCandyCreator builder;
    
    @Override
    public Identifiable build(ResultSet candyResultSet) throws SQLException 
    {        
        Identifiable candy = null;
        String candyType = candyResultSet.getString(CANDY_TYPE);
        
        if (candyType.equals(CHOCO_CANDY)){
            builder = new ChocolateCandyCreator();
        }
        else if (candyType.equals(CHOCO_CANDY_WITH_FILLING)){
            builder = new ChocolateCandyWithFillingCreator();
        }
        else if (candyType.equals(LOLLIPOP_CANDY)){
            builder = new LollipopCandyCreator();
        }
        else if (candyType.equals(LOLLIPOP_CANDY_WITH_FILLING)){
            builder = new LollipopCandyWithFillingCreator();
        }
        else {
            throw new IllegalArgumentException("'"+candyType+"' is incorrect CANDY TYPE");
        }
        
        candy = builder.create(candyResultSet);
        
        return candy;        
    }   
    
}
