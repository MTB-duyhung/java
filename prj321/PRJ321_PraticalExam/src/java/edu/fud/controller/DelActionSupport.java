/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import edu.fud.dao.ContactDAO;
import edu.fud.model.ContactInfo;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DelActionSupport extends ActionSupport{
    private int id;
    private List<ContactInfo> dsll;
    
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

    @Override
    public String execute() throws Exception {
        ContactDAO ct = new ContactDAO();
        ct.delete(id);
        dsll = ct.getAll();
        return "success";
    }
    
}
