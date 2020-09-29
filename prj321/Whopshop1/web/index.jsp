<%-- 
    Document   : index
    Created on : Jun 9, 2020, 1:18:42 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fud.model.Product"%>
<%@page import="fud.model.productDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>San pham</h1>
        <table border="1">
            <tr>
                <td>Product ID</td>
                <td>Product Name</td>
                <td>Unit</td>
                <td>Price</td>
            </tr>
            <%
                productDAO dsSanPham = new productDAO();
                List<Product> list = dsSanPham.getAll();
                for (Product sp : list) {
                    out.print("<tr>"
                            + "<td>" + sp.getId() + "</td>"
                            + "<td>" + sp.getName() + "</td>"
                            + "<td>" + sp.getUnit() + "</td>"
                            + "<td>" + sp.getPrice() + "</td>"
                            + "</tr>");
                }
            %>
        </table>
        <br>
        <br>
        <button onclick="location.href = 'product.jsp';">Add</button>
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
</body>
</html>
