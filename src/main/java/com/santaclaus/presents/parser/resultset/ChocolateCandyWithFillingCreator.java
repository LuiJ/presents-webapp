package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.ChocolateCandyWithFilling;
import com.santaclaus.presents.candies.FillingType;
import com.santaclaus.presents.candies.Identifiable;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChocolateCandyWithFillingCreator extends ChocolateCandyCreator {
    
    @Override
    public Identifiable create(ResultSet candyResultSet) throws SQLException {
        
        ChocolateCandyWithFilling candy = (ChocolateCandyWithFilling) super.create(candyResultSet);
        
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
    
    
