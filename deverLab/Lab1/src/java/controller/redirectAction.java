/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.URLDao;
import org.apache.struts2.convention.annotation.Namespace;
/**
 *
 * @author Admin
 */
//@Namespace("/yet/{shortURL}")
public class redirectAction {
    String shortURL,originalURL;
    public redirectAction() {
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }
    
    public String execute() throws Exception {
        URLDao udao=new URLDao();
        System.out.println("shortURL="+shortURL);
        originalURL=udao.shortToOriginal(shortURL);
        System.out.println("originalURL:"+originalURL);
        return "success";
    }
    
}
