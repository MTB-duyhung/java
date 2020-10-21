/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Blog {

    private int id;
    private String title;
    private Date date;
    private String img;
    private String content;

    public Blog() {
    }

    public Blog(int id, String title, Date date, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public Blog(int id, String title, Date date, String img, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.img = img;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", title=" + title + ", date=" + date + ", img=" + img + ", content=" + content + '}';
    }

}
