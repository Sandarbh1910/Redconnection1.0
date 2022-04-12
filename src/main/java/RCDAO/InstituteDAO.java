/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDAO;

import RCDBUTIL.DBConnection;
import RCPOJO.InstitutePOJO;
import RCPOJO.UserPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author sanda
 */
public class InstituteDAO {
    public static InstitutePOJO instituteLogin(String id,String password)
    {
        InstitutePOJO institute=null;
        try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from institutes where email=? and password=?");
            System.out.println(id+" "+password);
            ps.setString(1,id);
            ps.setString(2,password);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
                 institute=new InstitutePOJO(rs.getString("name"),rs.getString("email"),rs.getString("mob"),rs.getString("password"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"),rs.getString("address"));
             }
        }catch(Exception ex){ex.printStackTrace();
        }
        finally{return institute;}
        
        
    }
    
    
    
      public static String signupInstitute(InstitutePOJO institute)
    {
        try{
            
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into institutes (name,email,mob,password,city,state,country,pincode,address) values (?,?,?,?,?,?,?,?,?)");
            System.out.println(institute);
            ps.setString(1,institute.getName());
           
            ps.setString(2,institute.getEmail());
            ps.setString(3,institute.getMob());
            
            
            ps.setString(4,institute.getPassword());
            ps.setString(5, institute.getCity());
            ps.setString(6, institute.getState());
            ps.setString(7, institute.getCountry());
            ps.setString(8, institute.getPincode());
            ps.setString(9, institute.getAddress());
            
            
            ps.executeUpdate();
            
        }catch(SQLIntegrityConstraintViolationException ex)
        {
             return "Email/Mobile already exists!";
        }
        catch(Exception ex){ex.printStackTrace();
        return "Could not register! .Try again later";}
        
        return "Registration successful";
    }
      
      
      
      public static boolean getInstituteEmail(String email)
    {
        try{
             Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select email from institutes where email=?");
            
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
            PreparedStatement ps=conn.prepareStatement("update institutes set password=? where email=? ");
            
            ps.setString(1,password);
            ps.setString(2,email);
           
             ps.executeUpdate();
             return "Password Change Successfuly";

            
        }catch(Exception ex){ex.printStackTrace();
        return "Could not change password";}
    }
}
