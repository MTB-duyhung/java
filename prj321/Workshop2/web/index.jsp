<%-- 
    Document   : index
    Created on : Jun 16, 2020, 1:09:07 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fud.model.Student"%>
<%@page import="fud.model.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student</h1>

        <table border="1">

            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Gender</td>
                <td>DOB</td>
                <td></td>
            </tr>
            <%
                StudentDAO listStudent = new StudentDAO();
                List<Student> list = listStudent.getAll();
                for (Student s : list) {
                    out.print("<tr>"
                            + "<td>" + s.getID() + "</td>"
                            + "<td>" + s.getName() + "</td>"
                            + "<td>" + (s.isGender() == true ? "male" : "female") + "</td>"
                            + "<td>" + s.getDOB() + "</td>"
                            + "<td>" + "<a href='update.jsp?ID=" + s.getID() + "'>Update</a>" + "<a href='DeleteController?ID="+s.getID()+"'>Delete</a>" + "</td>"
                            + "</tr>");
                }
            %>
        </table>
        <br>
        <a href='add.jsp'>Create</a>

    </body>
</html>

