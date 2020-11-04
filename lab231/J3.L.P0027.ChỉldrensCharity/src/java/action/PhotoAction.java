/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import entity.Photo;
import java.util.ArrayList;
import model.PhotoDAO;

/**
 *
 * @author Admin
 */
public class PhotoAction {
    ArrayList<Photo> listP = new ArrayList<>();

    public ArrayList<Photo> getListP() {
        return listP;
    }

    public void setListP(ArrayList<Photo> listP) {
        this.listP = listP;
    }
    
    public PhotoAction() {
    }
    
    public String execute() throws Exception {
        PhotoDAO pdao=new PhotoDAO();
        listP=pdao.getPost();
        for (Photo h : listP) {
            System.out.println("img=" + h.getImg());
        }
        return "success";
    }
    
}
