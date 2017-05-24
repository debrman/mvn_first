package com.mycompany.mvn_first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaToOracle {
 
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:oracle:thin:@dbtest.bs.sibir.rt.ru:1521:testver";            
    private static final String user = "f008";
    private static final String password = "versch";
 
    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
 
    public static int mmmain(String args[]) {
        
        String query = "select count(*) from t_operators";
        int count = -1;
         
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
            rs = stmt.executeQuery(query);
 
            while (rs.next()) {
                count = rs.getInt(1);
                System.out.println("select count(*) from t_operators : " + count);
                //return count;
                
            }
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return count; //Возвращаем значение из БД
    }
    
 
}