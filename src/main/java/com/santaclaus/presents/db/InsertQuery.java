package com.santaclaus.presents.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertQuery extends Query {
    
    public InsertQuery(String queryString){
        super(queryString);
    }
    
    @Override
    protected ResultSet getResultSet(String queryString) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        return rs;
    }
    
}
