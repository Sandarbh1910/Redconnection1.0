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
        // conn=DriverManager.getConnection("jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_ecc5891f6c0f438","ba10ce866b6bc1","6fe390c7");
         conn=DriverManager.getConnection("jdbc:mysql://fl1vtisb2r40unlp:n0mdivap18fwxyjt@t07cxyau6qg7o5nz.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/lc2f1w92i8iy3ixm","fl1vtisb2r40unlp","n0mdivap18fwxyjt");
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
