/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Admin
 */
public class URL {

    String originalURL, shortURL;
    ArrayList<URL> ls;

    public URL() {
    }

    public URL(String shortURL, String originalURL) {
        this.originalURL = originalURL;
        this.shortURL = shortURL;
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

    public boolean check(String st) {
        URLDao udao = new URLDao();
        ls = (ArrayList<URL>) udao.getAllURL();
        for (URL u : ls) {
            if (u.getShortURL().equals(st)) {
                return false;
            }
        }
        return true;
    }

    public String random() {

        String st;
        boolean check = false;
        do {
            st = RandomStringUtils.randomAlphanumeric(6);
            check = check(st);
        } while (check == false);
        return st;

    }
    public boolean custom(String custom){
        if(!check(custom))return false;
        return true;
    }

}
