package com.santaclaus.presents.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Query { //перенести в DAOHelper, создавать отдельный класс запроса не надо
                                // то есть это получается как action item, который содержит данные и выполянет действия
                                // я бы разделил действия от запроса, создав методы без состояния, см. DAOHelper
    
    Connection connection = null; //модификаторы доступа должны пресутствовать
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private String queryString;
    
    public Query(String queryString){
        this.queryString = queryString;
    }    
    
    public ResultSet execute(){  
        
        try {            
            String driver = JdbcConfig.INSTANCE.getDriver();
            Class.forName(driver);
            
            String url = JdbcConfig.INSTANCE.getDbUrl();
            String user = JdbcConfig.INSTANCE.getUser();
            String password = JdbcConfig.INSTANCE.getPassword();
            
            connection = DriverManager.getConnection(url, user, password);  
            
            resultSet = getResultSet(queryString);
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
        
        return resultSet;
    }
    
    
    protected abstract ResultSet getResultSet(String queryString) throws SQLException;
    
    
    public void close(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
