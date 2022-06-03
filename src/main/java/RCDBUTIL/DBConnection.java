/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDBUTIL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sanda
 */
public class DBConnection {
     private static Connection conn=null;
    public static Connection getConnection()
    {
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/redconnection","root","Sandarbh19");
           System.out.println(conn+"in dao");
           return conn;
       }catch(Exception ex)
       {
           System.out.print("ERROR in DBConnection,Could not create connection");
       ex.printStackTrace();
       }
        
       return conn;
        
    }
    
    public static void closeConnection()
    {
        try{
            conn.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
