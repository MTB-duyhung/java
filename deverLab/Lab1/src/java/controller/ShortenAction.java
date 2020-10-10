/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;
import java.util.Collections;
import model.URL;
import model.URLDao;

/**
 *
 * @author Admin
 */
public class ShortenAction extends ActionSupport {

    String originalURL, shortURL, custom, newURL, error;

    public ShortenAction() {
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getNewURL() {
        return newURL;
    }

    public void setNewURL(String newURL) {
        this.newURL = newURL;
    }
    URLDao udao = new URLDao();
    URL u = new URL();

//    public void validate() {
//        if (custom.length() != 0) {
//            if (!u.custom(custom)) {
//                addFieldError("custom", "This custom link is exist. Please use another.");
//            }
//        }
//    }

    public String execute() throws Exception {

        if (custom.length() != 0) {
            if (u.custom(custom)) {
                shortURL = custom;
                newURL = "localhost:8080/Lab1/redirect?shortURL=" + shortURL;
            } else {
                newURL = "This custom link is exist. Please use another.";
            }
        } else {
            shortURL = u.random();
            newURL = "localhost:8080/Lab1/redirect?shortURL=" + shortURL;
        }
        u = new URL(shortURL, originalURL);
        udao.addURL(u);

        System.out.println("newURL=" + newURL);
        return "success";
    }

}
