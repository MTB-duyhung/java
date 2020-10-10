/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import model.Article;
import java.util.Map;
import model.ArticleDAO;

/**
 *
 * @author OS
 */
public class AboutAction {
    Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    public AboutAction() {
    }
    
    public String execute() throws Exception {
        ArticleDAO aDAO=new ArticleDAO();
        article=aDAO.getArticleById(5);
        System.out.println("title: "+article.getTitle());
        return "success"; 
    }
    
}
