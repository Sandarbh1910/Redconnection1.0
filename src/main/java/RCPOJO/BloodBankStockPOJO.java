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
public class BloodBankStockPOJO {
    private int id;
    private int ap;
     private int an;
     private int bp;
     private int bn;
     private int abp;
     private int abn;
     private int op;
     private int on;
    public BloodBankStockPOJO(int id, int ap, int an, int bp, int bn, int abp, int abn, int op, int on) {
        this.id = id;
        this.ap = ap;
        this.an = an;
        this.bp = bp;
        this.bn = bn;
        this.abp = abp;
        this.abn = abn;
        this.op = op;
        this.on = on;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
     
}
