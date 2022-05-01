/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDAO;

import RCDBUTIL.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author sanda
 */
public class BloodDonationResponseDAO {
    
    public static String respondToRequest(int reqno,String email,String bgrp,String institute)
    {
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into blooddonationresponse (requestno,email,bloodgrp,institute) values (?,?,?,?)");
            ps.setInt(1,reqno);
            ps.setString(2,email);
            ps.setString(3,bgrp);
            ps.setString(4,institute);
            ps.executeUpdate();
        }catch(SQLIntegrityConstraintViolationException ex){
            ex.printStackTrace();
            return "You already responded to this request";
        }
        catch(Exception ex)
        {
        ex.printStackTrace();
        return "Sorry could not respond to request,but you can visit the donation center for donation";
        }
        return "Responded Successfully,Now remember to visit the institute and donate on time because you chose to be someone's saviour";
    }
}
