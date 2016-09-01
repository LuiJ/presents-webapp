package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class AbstractCandyBuilder {
    
    public AbstractCandy build(ResultSet candyResultSet) throws SQLException {
        
        AbstractCandy candy = createSpecificCandy();
        
        int id = candyResultSet.getInt(AbstractCandy.FIELD_ID);
        candy.setId(id);
        
        int presentId = candyResultSet.getInt(AbstractCandy.FIELD_PRESENT_ID);
        candy.setPresentId(presentId);
        
        String type = candyResultSet.getString(AbstractCandy.FIELD_TYPE);
        candy.setType(type);
        
        String name = candyResultSet.getString(AbstractCandy.FIELD_NAME);
        candy.setName(name);
        
        double weight = candyResultSet.getDouble(AbstractCandy.FIELD_WEIGHT);
        candy.setWeight(weight);
        
        double price = candyResultSet.getDouble(AbstractCandy.FIELD_PRICE);    
        candy.setPrice(price);
        
        return candy;        
    }
    
    abstract protected AbstractCandy createSpecificCandy();
    
}
