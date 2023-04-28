package com.jose.database;

import java.sql.*;

public class SQLConnection {
    
   private Connection sqlConnection;

   public SQLConnection(String url, String user, String password){

        try{
            
            sqlConnection = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            // TODO: handle exception
        }

   };
}
