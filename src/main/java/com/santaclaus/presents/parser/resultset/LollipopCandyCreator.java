package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.Identifiable;
import com.santaclaus.presents.candies.LollipopCandy;
import com.santaclaus.presents.candies.TasteType;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LollipopCandyCreator extends AbstractCandyCreator {
    
    @Override
    public Identifiable create(ResultSet candyResultSet) throws SQLException {
        
        LollipopCandy candy = (LollipopCandy) super.create(candyResultSet);
        
        TasteType tasteType = TasteType.valueOf(candyResultSet.getString(LollipopCandy.FIELD_TASTE_TYPE));
        
        candy.setTasteType(tasteType);
        
        return candy;
        
    }  
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new LollipopCandy();
    }
    
    
}
