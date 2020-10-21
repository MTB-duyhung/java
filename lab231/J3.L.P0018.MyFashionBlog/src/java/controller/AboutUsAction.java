/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Information;
import model.InfoModel;

/**
 *
 * @author Admin
 */
public class AboutUsAction {

    Information info;

    public Information getInfo() {
        return info;
    }

    public void setInfo(Information info) {
        this.info = info;
    }

    public AboutUsAction() {
    }

    public String execute() throws Exception {
        InfoModel model = new InfoModel();
        info=model.getInfoPage();
        return "success";
    }

}
