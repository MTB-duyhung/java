/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import entity.Home;
import java.util.ArrayList;
import model.homeDAO;

/**
 *
 * @author Admin
 */
public class HomeAction {

    ArrayList<Home> listpost = new ArrayList<>();
    Home post1, post2;

    public Home getPost1() {
        return post1;
    }

    public void setPost1(Home post1) {
        this.post1 = post1;
    }

    public Home getPost2() {
        return post2;
    }

    public void setPost2(Home post2) {
        this.post2 = post2;
    }

    public ArrayList<Home> getListpost() {
        return listpost;
    }

    public void setListpost(ArrayList<Home> listpost) {
        this.listpost = listpost;
    }

    public HomeAction() {
    }

    public String execute() throws Exception {
        homeDAO hdao = new homeDAO();
        post1 = hdao.getDetailsPost(1);
        post2 = hdao.getDetailsPost(2);
        listpost = hdao.getPost(2);
        
        return "success";
    }

}
