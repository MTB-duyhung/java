<%-- 
    Document   : index
    Created on : May 26, 2020, 2:37:15 PM
    Author     : Admin
--%>

<%@page import="fud.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="fud.model.productsDAO"%>
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
                <td>Code</td>
                <td>Name</td>
                <td>Price</td>
            </tr>
            <%
                productsDAO dsSanPham=new productsDAO();
                List<Product> list=dsSanPham.showProduct("");
                for(Product sp:list){
                    out.print("<tr>"
                            + "<td>"+sp.getCode()+"</td>"
                            + "<td>"+sp.getName()+"</td>"
                            + "<td>"+sp.getPrice()+"</td>"
                            + "</tr>");
                }
            %>
        </table>
    </body>
</html>
