/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCDAO;

import RCDBUTIL.DBConnection;
import RCMail.Mailer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author sanda
 */
public class BloodDonationResponseDAO {
    
    public static String respondToRequest(int reqno,String email,String bgrp,String institute,int verificationotp)
    {
        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("insert into blooddonationresponse (requestno,email,bloodgrp,institute,verificationcode) values (?,?,?,?,?)");
            ps.setInt(1,reqno);
            ps.setString(2,email);
            ps.setString(3,bgrp);
            ps.setString(4,institute);
            ps.setInt(5, verificationotp);
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
    
    
    
    public static String verifyDonorAtInstitute(String email,String otp)
    {
        try{
            Connection conn=DBConnection.getConnection();

           
                PreparedStatement ps=conn.prepareStatement("update  blooddonationresponse set donationstatus='verified' where email=? and verificationcode=?");
           
            ps.setString(1,email);
            ps.setInt(2,Integer.parseInt(otp));
            
            if(ps.executeUpdate()>0)
            {
            Mailer.sendMail("Verified","Conrgatulations!\nYou saved a life.\n\nHealth credits will be deposited in your RedConnection account within 48 hours.",email);
            return "Donor Verified";
            }
            
            
        }
        catch(Exception ex)
        {
        ex.printStackTrace();
        return "Sorry could not verify at the moment ";
        }
        return "Sorry could not verify at the moment ";
    }
    
}

