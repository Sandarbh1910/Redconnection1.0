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
public class HealthCouponsPOJO {
    
    private int ccode;
    private String issuedate;
    private String ctype;

    public HealthCouponsPOJO(int ccode, String issuedate, String ctype) {
        
        this.ccode = ccode;
        this.issuedate = issuedate;
        this.ctype = ctype;
    }

   

    public int getCcode() {
        return ccode;
    }

    public void setCcode(int ccode) {
        this.ccode = ccode;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    
}
