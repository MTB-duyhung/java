/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import DAO.aboutMeDAO;
import model.aboutMe;

/**
 *
 * @author Admin
 */
public class aboutMeAction {

    String detail, name;

    public aboutMeAction() {
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() throws Exception {
        aboutMeDAO aDAO = new aboutMeDAO();
        aboutMe a = aDAO.getMe();

        if (a != null) {
            detail = a.getDetail();
            name = a.getName();
            return "success";
        }
        return "fail";
    }

}
