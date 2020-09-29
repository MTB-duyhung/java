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
public class EditActionSupport extends ActionSupport{
    private int id;
    private String fir, las, phone, error;
    private int group;
    private List<ContactInfo> dsll;
    public ContactInfo co = new ContactInfo();

    public EditActionSupport() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ContactInfo> getDsll() {
        return dsll;
    }

    public void setDsll(List<ContactInfo> dsll) {
        this.dsll = dsll;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
    @Override
    public String execute() throws Exception {
        ContactDAO ct = new ContactDAO();
        if(ct.getContact(id)!=null){
            co = ct.getContact(id); 
            return "success";
        }else{
            return "fail";
        }
    }
    
    public String editContact() throws Exception{
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
        ct.updateContact(id, fir, las, group, phone);
        dsll = ct.getAll();
        return "success";
    }
}
