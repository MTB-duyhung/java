/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Home;
import java.util.ArrayList;
import model.HomeModel;

/**
 *
 * @author Admin
 */
public class HomeAction {
    int page=1;
    int totalPage;
    ArrayList<Home> homes;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public ArrayList<Home> getHomes() {
        return homes;
    }

    public void setHomes(ArrayList<Home> homes) {
        this.homes = homes;
    }
    
    public HomeAction() {
    }
    
    public String execute() throws Exception {
        int pageSize=2;
        HomeModel model=new HomeModel();
        homes=model.getPost(page, pageSize);
        totalPage=model.getTotalPage(pageSize);
        return "success";
    }
    
}
