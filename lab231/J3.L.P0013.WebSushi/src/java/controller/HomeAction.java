/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import entity.Article;
import entity.Information;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import model.ArticleModel;
import model.InfoModel;
import model.ViewModel;

/**
 *
 * @author Admin
 */
public class HomeAction {

    int page = 1, pageSize = 2;
    int totalPage;
    String noContent;
    List<Article> content;

    public HomeAction() {
    }

    public String execute() throws Exception {
        ArticleModel model = new ArticleModel();
        InfoModel infoModel = new InfoModel();
        ViewModel viewModel=new ViewModel();
        List<Information> info = infoModel.getInfoPage();
        totalPage = model.getTotalRows();
        if (totalPage % pageSize == 0) {
            totalPage = totalPage / pageSize;
        } else {
            totalPage = totalPage / pageSize + 1;
        }
        if (page > totalPage) {
            noContent = "No article here!";
        } else {
            content =model.getArticlesFromTo(page, pageSize);
        }
        return "success";
    }

}
