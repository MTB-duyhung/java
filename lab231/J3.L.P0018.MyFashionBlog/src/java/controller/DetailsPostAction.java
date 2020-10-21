/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Home;
import model.HomeModel;

/**
 *
 * @author Admin
 */
public class DetailsPostAction {
    String id;
    Home content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public DetailsPostAction() {
    }
    
    public String execute() throws Exception {
        HomeModel model = new HomeModel();
        content=model.getDetailsPost(Integer.parseInt(id));
        System.out.println("id="+content.getTitle());
        return "success";
    }

    public Home getContent() {
        return content;
    }

    public void setContent(Home content) {
        this.content = content;
    }
    
}
