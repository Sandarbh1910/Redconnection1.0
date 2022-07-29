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
            Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_51c80e373ad78d4","ba10ce866b6bc1","6fe390c7");
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
