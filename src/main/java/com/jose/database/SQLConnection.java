package com.jose.database;

import java.sql.*;

public class SQLConnection{
    
   private Connection sqlConnection;
   private String url, user, password;
   private ResultSet set;

   public SQLConnection(String url, String user, String password){

        this.url = url;
        this.user = user;
        this.password = password;

   }

    private void getAllEntries() throws SQLException{
        final Statement st;        

        st = sqlConnection.createStatement();
        set =  st.executeQuery("SELECT * FROM Espectadores");
        
    }

    public ResultSet getResultSet(){
            return set;
    }

    public void runConnection(){
        try {
            sqlConnection = DriverManager.getConnection(url, user, password);
            getAllEntries();
        } catch (SQLException e) {
            //TODO: improve exception handeling
            e.printStackTrace();
        }
        
    }
}
