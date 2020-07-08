/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fud.controller;

import fud.model.Student;
import fud.model.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("ID"));
            StudentDAO dao = new StudentDAO();
            Student s = dao.findByID(id);
            if (s == null) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("s", s);
                RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StudentDAO dao = new StudentDAO();
            int id = Integer.parseInt(request.getParameter("ID"));
            String name = request.getParameter("Name");
            boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
            Date DOB = Date.valueOf(request.getParameter("DOB"));
            Student s = dao.findByID(id);
            s.setID(id);
            s.setName(name);
            s.setGender(gender);
            s.setDOB(DOB);
            dao.update(s);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
