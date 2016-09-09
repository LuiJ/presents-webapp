package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.ChocolateCandy;
import com.santaclaus.presents.candies.ChocoType;
import com.santaclaus.presents.candies.Identifiable;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChocolateCandyCreator extends AbstractCandyCreator {
    
    @Override
    public Identifiable create(ResultSet candyResultSet) throws SQLException {
        
        ChocolateCandy candy = (ChocolateCandy) super.create(candyResultSet);
        
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
