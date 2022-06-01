/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDAO;

import RCDBUTIL.DBConnection;
import RCHelper.Helper;
import RCPOJO.HealthCouponsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sanda
 */
public class HealthCouponsDAO {
    
    public static boolean generateCoupon(String email,String coupontype)
    {
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into healthcoupons (user,vissuedate,ctype) values(?,?,?)");
            ps.setString(1,email);
            ps.setString(2,Helper.todaysDate("yyyy/MM/dd"));
            ps.setString(3, coupontype);
            ps.executeUpdate();
            return true;
        }catch(Exception ex)
        {ex.printStackTrace();
        return false;}
        
    }
    
    
    public static ArrayList<HealthCouponsPOJO>getUserCouponList(String email)
    {
       ArrayList<HealthCouponsPOJO> clist=null;
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from healthcoupons where user=? and cstatus='active'");
            ps.setString(1,email);
            
            ResultSet rs=ps.executeQuery();
            clist=new ArrayList<HealthCouponsPOJO>();
            HealthCouponsPOJO h=null;
            while(rs.next())
            {
                h=new HealthCouponsPOJO(rs.getInt("ccode"),rs.getString("cissuedate"),rs.getString("ctype"));
                clist.add(h);
            }
        }catch(Exception ex)
        {ex.printStackTrace();
        }
        finally{
        return clist;}
    }
    
}
