/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.controller;

import Validate.Validate;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import edu.fud.dao.ContactDAO;
import edu.fud.model.ContactInfo;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AddActionSupport extends ActionSupport {

    private String fir, las, phone, error;
    private int group;
    private List<ContactInfo> dsll;

    public AddActionSupport() {
    }

    public String getFir() {
        return fir;
    }

    public void setFir(String fir) {
        this.fir = fir;
    }

    public String getLas() {
        return las;
    }

    public void setLas(String las) {
        this.las = las;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    public List<ContactInfo> getDsll() {
        return dsll;
    }

    public void setDsll(List<ContactInfo> dsll) {
        this.dsll = dsll;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String execute() throws Exception {
        ContactDAO ct = new ContactDAO();
        String erPhone = "Phone only contain 10 digits. ";
        String erString = "Some fields is empty. ";
        if (!Validate.checkPhone(phone)) {
            if (error != null) {
                error += erPhone;
            } else {
                error = erPhone;
            }
        }
        if (!Validate.checkString(fir) || !Validate.checkString(las) || !Validate.checkString(phone)) {
            if (error != null) {
                error += erString;
            } else {
                error = erString;
            }
        }
        if (error != null) {
            return "error";
        }
        if (ct.insert(fir, las, phone, group)) {
            dsll = ct.getAll();
            return "success";
        }
        return "fail";
    }

}
