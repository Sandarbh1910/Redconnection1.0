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
public class InstitutePOJO {
    private String name;
    private String email;
    private String mob;
    private String password;
    private String address;
    private String State;
    private String City;
    private String Country;
    private String pincode;
    private String instype;
    
    
    
    public InstitutePOJO(String name, String email, String mob, String password, String City, String State, String Country, String pincode ,String address,String instype) {
        this.name = name;
        this.email = email;
        this.mob = mob;
        this.password = password;
        this.address = address;
        this.State = State;
        this.City = City;
        this.Country = Country;
        this.pincode = pincode;
        this.instype=instype;
    }

    public String getInstype() {
        return instype;
    }

    public void setInstype(String instype) {
        this.instype = instype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    
    
    
    
}
