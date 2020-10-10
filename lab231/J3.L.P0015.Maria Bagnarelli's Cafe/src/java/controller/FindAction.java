/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Contact;
import model.ContactDAO;

/**
 *
 * @author Admin
 */
public class FindAction {
    String address,phone,email;
    ArrayList<Contact> list=new ArrayList<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Contact> getList() {
        return list;
    }

    public void setListContact(ArrayList<Contact> list) {
        this.list = list;
    }
    
    public FindAction() {
    }
    
    public String execute() throws Exception {
        ContactDAO cDAO=new ContactDAO();
        address=cDAO.getContact("Address").get(0).getValue();
        phone=cDAO.getContact("Phone").get(0).getValue();
        email=cDAO.getContact("Email").get(0).getValue();
        list=cDAO.getContact("work");
        for (Contact c:list) {
            System.out.println(c.getKey()+":"+c.getValue());
        }
        return "success";
    }
    
}
