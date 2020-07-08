<%-- 
    Document   : hienthi
    Created on : Jun 23, 2020, 1:51:07 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hien thi ket qua</h1>
        <c:forEach var="sp" items="${dssp}">
            Ma sp: ${sp.maSP}<br>
            Ten sp: ${sp.tenSP}<br>
            Gia: ${sp.gia}<br>
            ==================================<br>
        </c:forEach>
    </body>
</html>
