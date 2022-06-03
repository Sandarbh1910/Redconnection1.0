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
public class UserPOJO {

    @Override
    public String toString() {
        return "UserPOJO{" + "fname=" + fname + ", lname=" + lname + ", mob=" + mob + ", email=" + email + ", dob=" + dob + ", bloodgrp=" + bloodgrp + ", password=" + password + ", State=" + State + ", City=" + City + ", Country=" + Country + ", pincode=" + pincode + '}';
    }
    private String fname;
    private String lname;
    private String mob;
    private String email;
    private String dob;
    private String bloodgrp;
    private String password;
     private String State;
    private String City;
    private String Country;
    private String pincode;

    public UserPOJO(String fname, String lname, String mob, String email, String dob, String bloodgrp, String password,String City, String State, String Country, String pincode) {
        this.fname = fname;
        this.lname = lname;
        this.mob = mob;
        this.email = email;
        this.dob = dob;
        this.bloodgrp = bloodgrp;
        this.password = password;
        this.State = State;
        this.City = City;
        this.Country = Country;
        this.pincode = pincode;
    }
    
    
    public UserPOJO(String fname, String lname, String mob, String email, String dob, String bloodgrp, String City, String State, String Country, String pincode) {
        this.fname = fname;
        this.lname = lname;
        this.mob = mob;
        this.email = email;
        this.dob = dob;
        this.bloodgrp = bloodgrp;
        this.State = State;
        this.City = City;
        this.Country = Country;
        this.pincode = pincode;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return State;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public String getPincode() {
        return pincode;
    }

   

  

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
