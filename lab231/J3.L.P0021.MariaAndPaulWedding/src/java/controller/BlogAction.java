/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Blog;
import model.BlogDAO;

/**
 *
 * @author Admin
 */
public class BlogAction {

    ArrayList<Blog> listBlog = new ArrayList<>();
    int id;
    Blog blog;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public ArrayList<Blog> getListBlog() {
        return listBlog;
    }

    public void setListBlog(ArrayList<Blog> listBlog) {
        this.listBlog = listBlog;
    }

    public BlogAction() {
    }

    public String execute() throws Exception {
        BlogDAO bDAO = new BlogDAO();
        listBlog = bDAO.getAllBlog();
        return "success";
    }

    public String view() throws Exception {
        System.out.println("id= "+id);
        BlogDAO bDAO = new BlogDAO();
        blog=bDAO.getBlog(id);
        System.out.println("img= "+blog.getImg());
        return "success";
    }
}
