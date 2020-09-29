<%-- 
    Document   : product
    Created on : Jun 9, 2020, 1:51:53 PM
    Author     : Admin
--%>

<%@page import="fud.model.productDAO"%>
<%@page import="java.util.List"%>
<%@page import="fud.model.Product"%>
<%@page import="fud.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AddController" method="post">
            Product ID: <input type="text" name="productID"><br><br>
            Product Name: <input type="text" name="productName"><br><br>
            Unit: <input type="text" name="unit"><br><br>
            Price: <input type="text" name="price"><br><br>
            <input type="submit" value="Add"><br><br>
            <%
                Integer hitsCount = (Integer) application.getAttribute("hitCounter");
                if (hitsCount == null || hitsCount == 0) {
                    hitsCount = 1;
                } else {
                    hitsCount += 1;
                }
                application.setAttribute("hitCounter", hitsCount);

            %>
            <center>
                <p>Total number of visits: <%= hitsCount%></p>
            </center>
        </form>
    </body>
</html>
