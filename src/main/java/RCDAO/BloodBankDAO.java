/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDAO;

import RCDBUTIL.DBConnection;
import RCPOJO.BloodBankPOJO;
import RCPOJO.BloodBankStockPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sanda
 */
public class BloodBankDAO {
    
    public static boolean updateStock(int ap,int an,int bp,int bn,int abp,int abn,int op,int on,int id)
    {
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("update bloodbankstock set apb=?,anb=?,bpb=?,bnb=?,abpb=?,abnb=?,opb=?,onb=? where id=?");
            ps.setInt(1, ap);
            ps.setInt(2, an);
            ps.setInt(3, bp);
            ps.setInt(4, bn);
            ps.setInt(5, abp);
            ps.setInt(6, abn);
            ps.setInt(7, op);
            ps.setInt(8, on);
            ps.setInt(9, id);
            ps.executeUpdate();
            return true;
        }catch(Exception ex)
        {ex.printStackTrace(); return false;}
    }
    
    public static boolean createStock(int id)
    {
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into bloodbankstock (id) values (?)");
                    ps.setInt(1,id);
                    ps.executeUpdate();
                    return true;
                    
        }catch(Exception ex)
        {ex.printStackTrace(); return false;}
    }
    
    
     public static BloodBankStockPOJO loadStock(int id)
    {
        BloodBankStockPOJO bstock=null;
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from bloodbankstock where id=?");
                    ps.setInt(1,id);
                    
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                    {
                        bstock=new BloodBankStockPOJO(rs.getInt("id"),rs.getInt("apb"),rs.getInt("anb"),rs.getInt("bpb"),rs.getInt("bnb"),rs.getInt("abpb"),rs.getInt("abnb"),rs.getInt("opb"),rs.getInt("onb"));
                    }
                    return bstock;
                    
        }catch(Exception ex)
        {ex.printStackTrace(); return bstock;}
    }
    
   public static ArrayList<BloodBankPOJO> loadBanksByCountry(String country)
   {
       ArrayList<BloodBankPOJO>banklist=null;
       
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select i.name,i.email,i.mob,i.city,i.state,i.country,i.address,i.pincode,b.apb , b.anb,b.bpb,b.bnb,b.abpb,b.abnb,b.opb,b.onb from institutes i inner join  bloodbankstock b on i.id=b.id where i.country=?");
                   
                   ps.setString(1,country);
                    ResultSet rs=ps.executeQuery();
                    BloodBankPOJO b;
                    banklist=new ArrayList<BloodBankPOJO>();
                    while(rs.next())
                    {
                        b=new BloodBankPOJO(rs.getString("name"),rs.getString("mob"),rs.getString("email"),rs.getString("address"),rs.getString("state"),rs.getString("city"),rs.getString("country"),rs.getString("pincode"),rs.getInt("apb"),rs.getInt("anb"),rs.getInt("bpb"),rs.getInt("bnb"),rs.getInt("abpb"),rs.getInt("abnb"),rs.getInt("opb"),rs.getInt("onb"));
                        banklist.add(b);
                    }
                   
                   return banklist;
                    
        }catch(Exception ex)
        {ex.printStackTrace(); return banklist;}
   }
   
    public static ArrayList<BloodBankPOJO> loadBanksByState(String state,String country)
   {
       ArrayList<BloodBankPOJO>banklist=null;
       
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select i.name,i.email,i.mob,i.city,i.state,i.country,i.address,i.pincode,b.apb , b.anb,b.bpb,b.bnb,b.abpb,b.abnb,b.opb,b.onb from institutes i inner join  bloodbankstock b on i.id=b.id  having i.state=? and i.country=?");
                    ps.setString(1,state);
                   ps.setString(2,country);
                    ResultSet rs=ps.executeQuery();
                    BloodBankPOJO b;
                    banklist=new ArrayList<BloodBankPOJO>();
                    while(rs.next())
                    {
                        b=new BloodBankPOJO(rs.getString("name"),rs.getString("mob"),rs.getString("email"),rs.getString("address"),rs.getString("state"),rs.getString("city"),rs.getString("country"),rs.getString("pincode"),rs.getInt("apb"),rs.getInt("anb"),rs.getInt("bpb"),rs.getInt("bnb"),rs.getInt("abpb"),rs.getInt("abnb"),rs.getInt("opb"),rs.getInt("onb"));
                        banklist.add(b);
                    }
                   
                   return banklist;
                    
        }catch(Exception ex)
        {ex.printStackTrace(); return banklist;}
   }
    
     public static ArrayList<BloodBankPOJO> loadBanksByCity(String city,String state,String country)
   {
       ArrayList<BloodBankPOJO>banklist=null;
       
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select i.name,i.email,i.mob,i.city,i.state,i.country,i.address,i.pincode,b.apb , b.anb,b.bpb,b.bnb,b.abpb,b.abnb,b.opb,b.onb from institutes i inner join  bloodbankstock b on i.id=b.id  where i.city=? and i.state=? and i.country=?");
                   ps.setString(1,city);
                   ps.setString(2,state);
                   ps.setString(3,country);
                    ResultSet rs=ps.executeQuery();
                    BloodBankPOJO b;
                    banklist=new ArrayList<BloodBankPOJO>();
                    while(rs.next())
                    {
                        b=new BloodBankPOJO(rs.getString("name"),rs.getString("mob"),rs.getString("email"),rs.getString("address"),rs.getString("state"),rs.getString("city"),rs.getString("country"),rs.getString("pincode"),rs.getInt("apb"),rs.getInt("anb"),rs.getInt("bpb"),rs.getInt("bnb"),rs.getInt("abpb"),rs.getInt("abnb"),rs.getInt("opb"),rs.getInt("onb"));
                        banklist.add(b);
                    }
                   
                   return banklist;
                    
        }catch(Exception ex)
        {ex.printStackTrace(); return banklist;}
   }
     
      public static ArrayList<BloodBankPOJO> loadBanksByArea(String pincode)
   {
       ArrayList<BloodBankPOJO>banklist=null;
       
         try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select i.name,i.email,i.mob,i.city,i.state,i.country,i.address,i.pincode,b.apb , b.anb,b.bpb,b.bnb,b.abpb,b.abnb,b.opb,b.onb from institutes i inner join  bloodbankstock b on i.id=b.id  where i.pincode=?");
                   ps.setString(1, pincode);
                    ResultSet rs=ps.executeQuery();
                    BloodBankPOJO b;
                    banklist=new ArrayList<BloodBankPOJO>();
                    while(rs.next())
                    {
                        b=new BloodBankPOJO(rs.getString("name"),rs.getString("mob"),rs.getString("email"),rs.getString("address"),rs.getString("state"),rs.getString("city"),rs.getString("country"),rs.getString("pincode"),rs.getInt("apb"),rs.getInt("anb"),rs.getInt("bpb"),rs.getInt("bnb"),rs.getInt("abpb"),rs.getInt("abnb"),rs.getInt("opb"),rs.getInt("onb"));
                        banklist.add(b);
                    }
                   
                   return banklist;
                    
        }catch(Exception ex)
        {ex.printStackTrace(); return banklist;}
   }
    
}
