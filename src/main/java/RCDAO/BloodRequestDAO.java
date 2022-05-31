
package RCDAO;

import RCDBUTIL.DBConnection;
import RCPOJO.BloodRequestPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 *
 * @author sanda
 */
public class BloodRequestDAO {
    
    public static boolean submitRequest(BloodRequestPOJO breq)
    {
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into bloodrequest (email,mob,institute,icity,istate,icountry,ipincode,bloodgrp,units,date,purpose) values (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,breq.getEmail());
            ps.setString(2,breq.getMob());
            ps.setString(3,breq.getInstitute());
            ps.setString(4,breq.getIcity());
            ps.setString(5,breq.getIstate());
            ps.setString(6,breq.getIcountry());
            ps.setString(7,breq.getIpincode());
            ps.setString(8,breq.getBgrp());
            ps.setString(9,breq.getUnits());
            ps.setString(10,breq.getDate());
            ps.setString(11,breq.getPurpose());
            ps.executeUpdate();
        }catch(SQLIntegrityConstraintViolationException ex){
        ex.printStackTrace();return false;}
        catch(Exception ex){
        ex.printStackTrace(); return false;}
        return true;
    }
    
    public static ArrayList<BloodRequestPOJO> loadBloodRequestByCountry(String country)
    {ArrayList<BloodRequestPOJO>breqlist=null;
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from bloodrequest where icountry=? order by requestno desc");
            ps.setString(1, country);
         
            ResultSet rs= ps.executeQuery();
            BloodRequestPOJO breq=null;
            breqlist=new ArrayList<BloodRequestPOJO>();
            while(rs.next())
            {
                breq=new BloodRequestPOJO(rs.getString("requestno"),rs.getString("email"), rs.getString("mob"), rs.getString("institute"),rs.getString("icity"),rs.getString("istate"),rs.getString("icountry"), rs.getString("ipincode"),rs.getString("bloodgrp"),rs.getString("units"),rs.getString("date"),rs.getString("purpose"));
                breqlist.add(breq);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
        ex.printStackTrace();return null;}
        catch(Exception ex){
        ex.printStackTrace(); return null;}
        return breqlist;
    }
    
    public static ArrayList<BloodRequestPOJO> loadBloodRequestByState(String state,String country)
    { ArrayList<BloodRequestPOJO>breqlist=null;
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from bloodrequest where icountry=? and istate=? order by requestno desc");
            ps.setString(1, country);
            ps.setString(2, state);
         
            ResultSet rs= ps.executeQuery();
            BloodRequestPOJO breq=null;
           breqlist=new ArrayList<BloodRequestPOJO>();
            while(rs.next())
            {
                breq=new BloodRequestPOJO(rs.getString("requestno"),rs.getString("email"), rs.getString("mob"), rs.getString("institute"),rs.getString("icity"),rs.getString("istate"),rs.getString("icountry"), rs.getString("ipincode"),rs.getString("bloodgrp"),rs.getString("units"),rs.getString("date"),rs.getString("purpose"));
                breqlist.add(breq);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
        ex.printStackTrace();return null;}
        catch(Exception ex){
        ex.printStackTrace(); return null;}
        return breqlist;
    }
    
    
    public static ArrayList<BloodRequestPOJO> loadBloodRequestByCity(String city,String state,String country)
    {ArrayList<BloodRequestPOJO>breqlist=null;
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from bloodrequest where icountry=? and istate=? and icity=? order by requestno desc");
            ps.setString(1, country);
            ps.setString(2, state);
            ps.setString(3, city);
         
            ResultSet rs= ps.executeQuery();
            BloodRequestPOJO breq=null;
            breqlist=new ArrayList<BloodRequestPOJO>();
            while(rs.next())
            {
                breq=new BloodRequestPOJO(rs.getString("requestno"),rs.getString("email"), rs.getString("mob"), rs.getString("institute"),rs.getString("icity"),rs.getString("istate"),rs.getString("icountry"), rs.getString("ipincode"),rs.getString("bloodgrp"),rs.getString("units"),rs.getString("date"),rs.getString("purpose"));
                breqlist.add(breq);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
        ex.printStackTrace();return null;}
        catch(Exception ex){
        ex.printStackTrace(); return null;}
        return breqlist;
    }
    
    
     public static ArrayList<BloodRequestPOJO> loadBloodRequestByArea(String pincode)
    {ArrayList<BloodRequestPOJO>breqlist=null;
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from bloodrequest where ipincode=? order by requestno desc");
            ps.setString(1, pincode);
            
         
            ResultSet rs= ps.executeQuery();
            BloodRequestPOJO breq=null;
            breqlist=new ArrayList<BloodRequestPOJO>();
            while(rs.next())
            {
                breq=new BloodRequestPOJO(rs.getString("requestno"),rs.getString("email"), rs.getString("mob"), rs.getString("institute"),rs.getString("icity"),rs.getString("istate"),rs.getString("icountry"), rs.getString("ipincode"),rs.getString("bloodgrp"),rs.getString("units"),rs.getString("date"),rs.getString("purpose"));
                breqlist.add(breq);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
        ex.printStackTrace();return null;}
        catch(Exception ex){
        ex.printStackTrace(); return null;}
        return breqlist;
    }
    
    
    
}
