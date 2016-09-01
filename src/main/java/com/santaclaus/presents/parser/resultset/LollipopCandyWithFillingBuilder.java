package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.LollipopCandyWithFilling;
import com.santaclaus.presents.candies.properties.FillingType;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LollipopCandyWithFillingBuilder extends LollipopCandyBuilder {
      
    @Override
    public LollipopCandyWithFilling build(ResultSet candyResultSet) throws SQLException {
        
        LollipopCandyWithFilling candy = (LollipopCandyWithFilling) super.build(candyResultSet);
        
        FillingType fillingType = FillingType.valueOf(candyResultSet.getString(LollipopCandyWithFilling.FIELD_FILLING_TYPE));
        
        candy.setFillingType(fillingType);
        
        return candy;
        
    }
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new LollipopCandyWithFilling();
    }
    
}
    
