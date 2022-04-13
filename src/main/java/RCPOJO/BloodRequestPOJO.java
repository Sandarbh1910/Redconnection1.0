/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCPOJO;

/**
 *
 * @author sanda
 */
public class BloodRequestPOJO {
    private String reqno;
     private String email;
            private String mob ;
           private  String institute ;
           private  String icity ;
           private  String istate ;
           private  String icountry ;
           private  String ipincode ;
           private  String bgrp ;
           private  String units ;
           private  String date ;
           private  String purpose ;

    public BloodRequestPOJO(String email, String mob, String institute, String icity, String istate, String icountry, String ipincode, String bgrp, String units, String date, String purpose) {
        this.email = email;
        this.mob = mob;
        this.institute = institute;
        this.icity = icity;
        this.istate = istate;
        this.icountry = icountry;
        this.ipincode = ipincode;
        this.bgrp = bgrp;
        this.units = units;
        this.date = date;
        this.purpose = purpose;
    }

    public BloodRequestPOJO(String reqno, String email, String mob, String institute, String icity, String istate, String icountry, String ipincode, String bgrp, String units, String date, String purpose) {
        this.reqno = reqno;
        this.email = email;
        this.mob = mob;
        this.institute = institute;
        this.icity = icity;
        this.istate = istate;
        this.icountry = icountry;
        this.ipincode = ipincode;
        this.bgrp = bgrp;
        this.units = units;
        this.date = date;
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "BloodRequestPOJO{" + "reqno=" + reqno + ", email=" + email + ", mob=" + mob + ", institute=" + institute + ", icity=" + icity + ", istate=" + istate + ", icountry=" + icountry + ", ipincode=" + ipincode + ", bgrp=" + bgrp + ", units=" + units + ", date=" + date + ", purpose=" + purpose + '}';
    }

           
           
    public String getReqno() {
        return reqno;
    }

    public void setReqno(String reqno) {
        this.reqno = reqno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getIcity() {
        return icity;
    }

    public void setIcity(String icity) {
        this.icity = icity;
    }

    public String getIstate() {
        return istate;
    }

    public void setIstate(String istate) {
        this.istate = istate;
    }

    public String getIcountry() {
        return icountry;
    }

    public void setIcountry(String icountry) {
        this.icountry = icountry;
    }

    public String getIpincode() {
        return ipincode;
    }

    public void setIpincode(String ipincode) {
        this.ipincode = ipincode;
    }

    public String getBgrp() {
        return bgrp;
    }

    public void setBgrp(String bgrp) {
        this.bgrp = bgrp;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
           
           
           
}
