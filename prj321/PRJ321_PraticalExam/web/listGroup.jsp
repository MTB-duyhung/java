<%-- 
    Document   : listGroup
    Created on : Jul 19, 2020, 2:58:37 PM
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
        <h1>List of Groups</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Group Name</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="group" items="${dsn}">
                <tr>
                    <td>${group.ID}</td>
                    <td>${group.groupname}</td>
                    <td>${group.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="Addgroup.jsp">
            <input type="button" value="Add Group" />
        </a>
        <a href="list">
            <input type="button" value="List Contact" />
        </a>
    </body>
</html>
