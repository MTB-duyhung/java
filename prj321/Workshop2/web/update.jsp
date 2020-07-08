<%-- 
    Document   : update
    Created on : Jun 16, 2020, 2:33:35 PM
    Author     : Admin
--%>

<%@page import="fud.model.StudentDAO"%>
<%@page import="fud.model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            StudentDAO dao = new StudentDAO();
            Student s = dao.findByID(Integer.parseInt(request.getParameter("ID")));
        %>
        <form action="UpdateController" method="post">
            <input type="hidden" name="ID" value="<%= s.getID()%>"/>
            Name: <input type="text" name="Name" value="<%=s.getName()%>"/><br><br>
            Gender: 
            Male<input type="radio" name="Gender" value="true" <%=s.isGender()?"checked":""%>/>
            Female<input type="radio" name="Gender" value="false"<%=!s.isGender()?"checked":""%>/><br><br>
            DOB: <input type="date" name="DOB" value="<%=s.getDOB()%>"><br><br>
            <input type="submit" name="action" value="Update"><br><br>
        </form>
    </body>
</html>
