/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDAO;

import RCDBUTIL.DBConnection;
import RCPOJO.UserPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sanda
 */
public class UserDAO {
    
    
    public static boolean signupUser(UserPOJO user)
    {
        try{
            
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into users values (?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println(user);
            ps.setString(1,user.getFname());
            ps.setString(2,user.getLname());
            ps.setString(3,user.getMob());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getDob());
            ps.setString(6,user.getBloodgrp());
            ps.setString(7,user.getPassword());
            ps.setString(8, user.getCity());
            ps.setString(9, user.getState());
            ps.setString(10, user.getCountry());
            ps.setString(11, user.getPincode());
            
            
            ps.executeUpdate();
            
        }catch(Exception ex){ex.printStackTrace();
        return false;}
        
        return true;
    }
    
    
    public static UserPOJO userLogin(String id,String password)
    {        UserPOJO user=null;

        try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from users where email=? and password=?");
            System.out.println(id+" "+password);
            ps.setString(1,id);
            ps.setString(2,password);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             user=new UserPOJO(rs.getString("firstname"),rs.getString("lastname"),rs.getString("mob"),rs.getString("email"),rs.getString("dob"),rs.getString("blood group"),rs.getString("password"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"));
            
        }catch(Exception ex){ex.printStackTrace();}
         finally{return user;}
    }
    
    
    
     
}
