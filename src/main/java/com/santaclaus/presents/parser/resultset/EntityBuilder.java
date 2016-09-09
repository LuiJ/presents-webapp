package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.Identifiable;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface EntityBuilder {

    Identifiable build(ResultSet resultSet) throws SQLException;
    
}
