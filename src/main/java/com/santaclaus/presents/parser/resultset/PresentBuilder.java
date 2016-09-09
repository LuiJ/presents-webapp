package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.Identifiable;
import com.santaclaus.presents.present.Present;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PresentBuilder implements EntityBuilder {

    @Override
    public Identifiable build(ResultSet presentResultSet) throws SQLException {
        
            Present present = new Present();
            
            int id = presentResultSet.getInt(Present.FIELD_ID);
            present.setId(id);
            
            String name = presentResultSet.getString(Present.FIELD_NAME);
            present.setName(name);
            
            return present;        
    }    
}
