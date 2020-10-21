/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.GuestBook;
import model.GuestDAO;

/**
 *
 * @author Admin
 */
public class GuestAction {
    ArrayList<GuestBook> listGuest;

    public ArrayList<GuestBook> getListGuest() {
        return listGuest;
    }

    public void setList(ArrayList<GuestBook> listGuest) {
        this.listGuest = listGuest;
    }
    
    public GuestAction() {
    }
    
    public String execute() throws Exception {
        GuestDAO g=new GuestDAO();
        listGuest=g.getGuest();
        return "success";
    }
    
}
