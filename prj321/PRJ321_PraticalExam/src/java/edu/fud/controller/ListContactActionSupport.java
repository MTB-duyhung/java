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
public class ListContactActionSupport extends ActionSupport{
    private List<ContactInfo> dsll;
    private ContactInfo ci = new ContactInfo();
    private ContactDAO dao = new ContactDAO();

    public ListContactActionSupport() {
    }

    public List<ContactInfo> getDsll() {
        return dsll;
    }

    public void setDsll(List<ContactInfo> dsll) {
        this.dsll = dsll;
    }

    public ContactInfo getCi() {
        return ci;
    }

    public void setCi(ContactInfo ci) {
        this.ci = ci;
    }

    public ContactDAO getDao() {
        return dao;
    }

    public void setDao(ContactDAO dao) {
        this.dao = dao;
    }

    @Override
    public String execute() throws Exception {
        dsll = dao.getAll();
        return "success";
    }
}
