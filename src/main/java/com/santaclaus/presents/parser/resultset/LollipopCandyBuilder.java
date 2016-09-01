package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.LollipopCandy;
import com.santaclaus.presents.candies.properties.TasteType;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LollipopCandyBuilder extends AbstractCandyBuilder {
    
    @Override
    public LollipopCandy build(ResultSet candyResultSet) throws SQLException {
        
        LollipopCandy candy = (LollipopCandy) super.build(candyResultSet);
        
        TasteType tasteType = TasteType.valueOf(candyResultSet.getString(LollipopCandy.FIELD_TASTE_TYPE));
        
        candy.setTasteType(tasteType);
        
        return candy;
        
    }  
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new LollipopCandy();
    }
    
    
}
