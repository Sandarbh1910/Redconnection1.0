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
    
    
    
      public static boolean signupInstitute(InstitutePOJO institute)
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
            
        }catch(Exception ex){ex.printStackTrace();
        return false;}
        
        return true;
    }
}
