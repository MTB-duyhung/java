/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class TestDB {
    public static void main(String[] args) throws Exception {
        ArticleModel artical=new ArticleModel();
        System.out.println("is="+artical.getTotalRows());
        ViewModel v=new ViewModel();
        System.out.println(""+v.getView());
        v.updateView();
    }
}
