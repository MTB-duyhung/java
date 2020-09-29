/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import model.ArticleModel;

/**
 *
 * @author Admin
 */
public class DetailsPostAction {
    String id;
    Article article;
    public DetailsPostAction() {
    }
    
    public String execute() throws Exception {
        ArticleModel model;
        try{
            model=new ArticleModel();
            article=model.getDetailsPost(Integer.parseInt(id));
            return "success";
        }catch(Exception e){
            return "error";
        }
    }
    
}
