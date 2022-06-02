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
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author sanda
 */
public class UserDAO {
    
    
    public static String signupUser(UserPOJO user)
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
            
        }catch(SQLIntegrityConstraintViolationException ex)
        {
             return "Email/Mobile already exists!";
        }
        catch(Exception ex){ex.printStackTrace();
        return "Could not register! .Try again later";}
        
        return "Registration successful";
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
             user=new UserPOJO(rs.getString("firstname"),rs.getString("lastname"),rs.getString("mob"),rs.getString("email"),rs.getString("dob"),rs.getString("bloodgroup"),rs.getString("password"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"));
            
        }catch(Exception ex){ex.printStackTrace();}
         finally{return user;}
    }
    
    public static boolean getUserEmail(String email)
    {
        try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select email from users where email=?");
            
            ps.setString(1,email);
           
             ResultSet rs=ps.executeQuery();
             return rs.next();

            
        }catch(Exception ex){ex.printStackTrace();
        return false;}
         
    }
    
    
    public static String createNewPassword(String email,String password)
    {
         try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("update users set password=? where email=? ");
            
            ps.setString(1,password);
            ps.setString(2,email);
           
             ps.executeUpdate();
             return "Password Change Successfuly";

            
        }catch(Exception ex){ex.printStackTrace();
        return "Could not change password";}
    }
    
    
    
    public static String getDonorName(String email)
    {
        String donor="";
        try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select firstname,lastname from users where email=?");
            
          
            ps.setString(1,email);
           
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
                 donor=(rs.getString("firstname")+" "+rs.getString("lastname"));
             }
            
             return donor ;

            
        }catch(Exception ex){ex.printStackTrace();
        return donor;}
        finally{
        return donor;}
    }
    
    
    public static int getUserHealthCredits(String email)
    {
        int credits=0;
        try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select healthcredits from users where email=?");
            
          
            ps.setString(1,email);
           
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
                 credits=(rs.getInt("healthcredits"));
             }
            
             return credits ;

            
        }catch(Exception ex){ex.printStackTrace();
        return credits;}
        finally{
        return credits;}
    }
    
    
    public static boolean updateHealthCredits(String email,int change)
    {
        int credits=0;
        try{
            credits=UserDAO.getUserHealthCredits(email);
            System.out.println("Current credits "+credits);
            if(change<0&&credits<Math.abs(change))
            {
                return false;
            }
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("update users set healthcredits=?  where email=?");
            
          ps.setInt(1, credits+change);
            ps.setString(2,email);
           
             ps.executeUpdate();
             
            
             return true ;

            
        }catch(Exception ex){ex.printStackTrace();
        return false;}
        
    }
    
    public static String updateUserProfile(UserPOJO user,String email)
    {
        
        try {
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("update users set firstname=?,lastname=?,mob=?,email=?,dob=?,bloodgroup=?,city=?,state=?,country=?,pincode=? where email=?");
            
          ps.setString(1, user.getFname());
            ps.setString(2,user.getLname());
            ps.setString(3, user.getMob());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getDob());
            ps.setString(6, user.getBloodgrp());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getState());
            ps.setString(9, user.getCountry());
            ps.setString(10, user.getPincode());
            ps.setString(11, email);
           
             ps.executeUpdate();
             return "Details updated successfully!";
        }catch(SQLIntegrityConstraintViolationException ex){ex.printStackTrace();return "Email/Mobile already exists!";}catch(Exception ex)
        {ex.printStackTrace();return "Sorry could not update details";}
        
    }
    
     
}
