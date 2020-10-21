/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Photo;
import model.PhotoDAO;

/**
 *
 * @author Admin
 */
public class PhotoAction {
    ArrayList<Photo> listPhoto=new ArrayList<>();

    public ArrayList<Photo> getListPhoto() {
        return listPhoto;
    }

    public void setListPhoto(ArrayList<Photo> listPhoto) {
        this.listPhoto = listPhoto;
    }
    
    public PhotoAction() {
    }
    
    public String execute() throws Exception {
        PhotoDAO pDAO=new PhotoDAO();
        listPhoto=pDAO.getPhoto();
        return "success";
    }
    
}
