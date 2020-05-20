/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feereport;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Accountant implements Serializable{

    int accID;
    String accName, accPass, accEmail, accContactNo;

    public Accountant() {
    }

    public Accountant(int accID, String accName, String accPass, String accEmail, String accContactNo) {
        this.accID = accID;
        this.accName = accName;
        this.accPass = accPass;
        this.accEmail = accEmail;
        this.accContactNo = accContactNo;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

    public String getAccEmail() {
        return accEmail;
    }

    public void setAccEmail(String accEmail) {
        this.accEmail = accEmail;
    }

    public String getAccContactNo() {
        return accContactNo;
    }

    public void setAccContactNo(String accContactNo) {
        this.accContactNo = accContactNo;
    }

    @Override
    public String toString() {
        return "Accountant{" + "accName=" + accName + ", accPass=" + accPass + ", accEmail=" + accEmail + ", accContactNo=" + accContactNo + '}';
    }

}
