package com.jose.threading;

import javafx.concurrent.Task;
import java.sql.*;

import com.jose.database.SQLConnection;

public class DBTask extends Task<ResultSet>{

    SQLConnection connection;
    ResultSet rs;

    public DBTask(SQLConnection c){
        connection = c;
    }

    //TODO: improve exception handeling

    @Override
    protected ResultSet call() throws Exception {
        
        connection.runConnection();
        rs = connection.getResultSet();

        updateValue(rs);
        return rs;

    }

    
}
