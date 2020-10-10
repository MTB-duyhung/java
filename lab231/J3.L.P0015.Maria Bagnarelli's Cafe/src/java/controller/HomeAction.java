/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Article;
import java.util.ArrayList;
import model.ArticleDAO;

/**
 *
 * @author Admin
 */
public class HomeAction {
    ArrayList<Article> listArticles=new ArrayList<>();
    Article article;

    public ArrayList<Article> getListArticles() {
        return listArticles;
    }

    public void setListArticles(ArrayList<Article> listArticles) {
        this.listArticles = listArticles;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    public HomeAction() {
    }
    
    public String execute() throws Exception {
        ArticleDAO aDAO=new ArticleDAO();
        listArticles=aDAO.getArticle(2, 2);
        article=aDAO.getArticleById(1);
        return "success";
    }
    
}
