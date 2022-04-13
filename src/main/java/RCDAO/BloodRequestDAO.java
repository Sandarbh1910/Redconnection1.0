
package RCDAO;

import RCDBUTIL.DBConnection;
import RCPOJO.BloodRequestPOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

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
}
