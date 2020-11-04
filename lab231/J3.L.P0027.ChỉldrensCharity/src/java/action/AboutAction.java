/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import entity.About;
import java.util.ArrayList;
import model.AboutDAO;

/**
 *
 * @author Admin
 */
public class AboutAction {

    ArrayList<About> list = new ArrayList<>();

    public ArrayList<About> getList() {
        return list;
    }

    public void setList(ArrayList<About> list) {
        this.list = list;
    }

    public AboutAction() {
    }

    public String execute() throws Exception {
        AboutDAO adao = new AboutDAO();
        list = adao.getPost();
        
        return "success";
    }

}
