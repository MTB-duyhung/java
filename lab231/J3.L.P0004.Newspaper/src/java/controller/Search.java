/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ArticleDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Search</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Search at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            final int ARTICLE_PAGE = 2;
            HttpSession session = request.getSession();
            int pageCurrent = Integer.parseInt(request.getParameter("page"));
            String keyword = (String) session.getAttribute("keyword");
            ArticleDAO articles = new ArticleDAO();
            Article mostRecentArticle = articles.getRecentArticle(1).get(0);
            request.setAttribute("mostRecentArticle", mostRecentArticle);
            ArrayList<Article> fiveRecentAticle = articles.getRecentArticle(5);
            request.setAttribute("fiveRecentAticle", fiveRecentAticle);
            ArrayList<Article> listSearch = articles.getListAticleSearch(ARTICLE_PAGE, pageCurrent, keyword);
            request.setAttribute("listSearch", listSearch);
            int numberPage = articles.getNumberPage(ARTICLE_PAGE, keyword);
            request.setAttribute("numberPage", numberPage);
            request.setAttribute("pageCurrent", pageCurrent);
            if (listSearch.size() == 0) {
                request.setAttribute("error", "Not found");
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred");
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String keyword = request.getParameter("keyword");
            if (keyword == null || keyword.isEmpty()) {
                String servletPrev = request.getHeader("referer");
                String nameServletPrev = servletPrev.substring(servletPrev.lastIndexOf("/") + 1);
                response.sendRedirect(nameServletPrev);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("keyword", keyword);
                response.sendRedirect("Search?page=1");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred");
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
