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
public class BloodBankPOJO {
     private String name;
   
    private String mob;
    private String email;
    
    private String address;
    
     private String State;
    private String City;
    private String Country;
    private String pincode;
     private int ap;
     private int an;
     private int bp;
     private int bn;
     private int abp;
     private int abn;
     private int op;
     private int on;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public int getBn() {
        return bn;
    }

    public void setBn(int bn) {
        this.bn = bn;
    }

    public int getAbp() {
        return abp;
    }

    public void setAbp(int abp) {
        this.abp = abp;
    }

    public int getAbn() {
        return abn;
    }

    public void setAbn(int abn) {
        this.abn = abn;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getOn() {
        return on;
    }

    public void setOn(int on) {
        this.on = on;
    }

    public BloodBankPOJO(String name, String mob, String email, String address, String State, String City, String Country, String pincode, int ap, int an, int bp, int bn, int abp, int abn, int op, int on) {
        this.name = name;
        this.mob = mob;
        this.email = email;
        this.address = address;
        this.State = State;
        this.City = City;
        this.Country = Country;
        this.pincode = pincode;
        this.ap = ap;
        this.an = an;
        this.bp = bp;
        this.bn = bn;
        this.abp = abp;
        this.abn = abn;
        this.op = op;
        this.on = on;
    }
    
}
