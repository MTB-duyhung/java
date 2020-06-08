<%-- 
    Document   : scriptingElements
    Created on : May 26, 2020, 1:28:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            for (int i = 0; i < 5; i++) {
                out.print("<h4>" + i + "</h4>");
            }
            int result = add(5, 6);
            out.print("<p> Result: " + result + "</p>");
        %>
        <%= "Le Thi Thanh Nhan"%>
        <br><br>
        Logic expression: <%=5 > 6%>
        <%!
            String name = "NhanLTT";

            int add(int a, int b) {
                return a + b;
            }
        %>
    </body>
</html>
