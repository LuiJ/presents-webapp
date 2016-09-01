package com.santaclaus.presents.db;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectQuery extends Query {
    
    public SelectQuery(String queryString){
        super(queryString);
    }
    
    @Override
    protected ResultSet getResultSet(String queryString) throws SQLException {
        statement = connection.createStatement(); 
        ResultSet rs = statement.executeQuery(queryString); 
        return rs;
    }
    
}
