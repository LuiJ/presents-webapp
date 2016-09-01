package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.ChocolateCandy;
import com.santaclaus.presents.candies.properties.ChocoType;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChocolateCandyBuilder extends AbstractCandyBuilder {
    
    @Override
    public ChocolateCandy build(ResultSet candyResultSet) throws SQLException {
        
        ChocolateCandy candy = (ChocolateCandy) super.build(candyResultSet);
        
        ChocoType chocoType = ChocoType
        .valueOf(candyResultSet.getString(ChocolateCandy.FIELD_CHOCO_TYPE));
        
        candy.setChocoType(chocoType);
        
        return candy;
        
    }
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new ChocolateCandy();
    }
    
}
