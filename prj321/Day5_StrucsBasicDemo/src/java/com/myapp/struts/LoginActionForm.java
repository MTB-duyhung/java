/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import connection.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.MultipartRequestHandler;
import org.apache.tomcat.jni.User;

/**
 *
 * @author Admin
 */
public class LoginActionForm extends org.apache.struts.action.ActionForm {

    private String username, password;
    
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public LoginActionForm() throws Exception {
        super();
        conn = DBUtil.openConnection();
    }

    public LoginActionForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkLogin() {
        String sql = "Select * from registration where username=? and password=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            if (count == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }

        return false;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        username = "";
        password = "";
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        return errors;
    }
}
