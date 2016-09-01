package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.ChocolateCandyWithFilling;
import com.santaclaus.presents.candies.properties.FillingType;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChocolateCandyWithFillingBuilder extends ChocolateCandyBuilder {
    
    @Override
    public ChocolateCandyWithFilling build(ResultSet candyResultSet) throws SQLException {
        
        ChocolateCandyWithFilling candy = (ChocolateCandyWithFilling) super.build(candyResultSet);
        
        FillingType fillingType = FillingType
        .valueOf(candyResultSet.getString(ChocolateCandyWithFilling.FIELD_FILLING_TYPE));
        
        candy.setFillingType(fillingType);
        
        return candy;
        
    }
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new ChocolateCandyWithFilling();
    }
    
}
    
    
