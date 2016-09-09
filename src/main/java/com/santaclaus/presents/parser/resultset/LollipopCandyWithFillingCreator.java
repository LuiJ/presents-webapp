package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.LollipopCandyWithFilling;
import com.santaclaus.presents.candies.FillingType;
import com.santaclaus.presents.candies.Identifiable;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LollipopCandyWithFillingCreator extends LollipopCandyCreator {
      
    @Override
    public Identifiable create(ResultSet candyResultSet) throws SQLException {
        
        LollipopCandyWithFilling candy = (LollipopCandyWithFilling) super.create(candyResultSet);
        
        FillingType fillingType = FillingType.valueOf(candyResultSet.getString(LollipopCandyWithFilling.FIELD_FILLING_TYPE));
        
        candy.setFillingType(fillingType);
        
        return candy;
        
    }
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new LollipopCandyWithFilling();
    }
    
}
    
