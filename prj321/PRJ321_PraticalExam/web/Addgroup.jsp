<%-- 
    Document   : Addgroup
    Created on : Jul 19, 2020, 3:20:02 PM
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
         <h1>Add a Group</h1>
         <h5 style="color: red">${errorg}</h5>
        <form action="addgroup">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td>
                            <input type="text" name="Groupname" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
                            <input type="text" name="description" value="" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Add" />
            <a href="listg">
                <input type="button" value="Return To Group List" />
            </a>
        </form>
    </body>
</html>
