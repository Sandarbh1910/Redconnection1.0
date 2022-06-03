/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDAO;

import RCDBUTIL.DBConnection;
import RCPOJO.EventsPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author sanda
 */
public class EventsDAO {

    public static boolean planEvent( EventsPOJO e) {
        try {
            System.out.println("Reached plan event dao");
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into events (eventname ,organiser,venue,contact,sdate,edate,stime,etime,planneruser)values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, e.getEvent());
            ps.setString(2, e.getOrganiser());
            ps.setString(3, e.getVenue());
            ps.setString(4, e.getContact());
            ps.setString(5, e.getFrom());
            ps.setString(6, e.getTill());
            ps.setString(7, e.getStime());
            ps.setString(8, e.getEtime());
            ps.setString(9, e.getPlanner());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
    
    public static ArrayList<EventsPOJO>getInstituteEvents(String email)
    {
        ArrayList<EventsPOJO> elist=null;
         try {
             LocalDate date =  LocalDate.now();
            
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("select * from events where planneruser=? and edate>=?");
            ps.setString(1, email);
            ps.setString(2, date.toString());
           EventsPOJO e=null;
            ResultSet rs=ps.executeQuery();
             
             elist=new ArrayList<EventsPOJO>();
            while(rs.next())
            {
                System.out.println("Entered loop");
                e=new EventsPOJO(rs.getString("eventname"),rs.getString("organiser"),rs.getString("venue"),rs.getString("contact"),rs.getString("sdate"),rs.getString("edate"),rs.getString("stime"),rs.getString("etime"),rs.getString("planneruser"),rs.getInt("eventid"));
                elist.add(e);
            }
            return elist;
        } catch (Exception ex) {
            ex.printStackTrace();
            return elist;
        }
    }
    
    
    public static boolean deleteEvent(String eid,String email )
    {
        try{
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("delete from events where planneruser=? and eventid=?");
            ps.setString(1, email);
            ps.setInt(2, Integer.parseInt(eid));
            ps.executeUpdate();
            return true;
        }catch(Exception ex){ex.printStackTrace();return false;}
    }
}
