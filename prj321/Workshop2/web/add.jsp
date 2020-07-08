<%-- 
    Document   : add
    Created on : Jun 16, 2020, 2:55:30 PM
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
        <form action="AddController" method="post">
            Name: <input type="text" name="Name"><br><br>
            Gender: <input type="radio" name="Gender" value="true" selected>Male
            <input type="radio" name="Gender" value="false" selected>Female<br><br>
            DOB: <input type="date" name="DOB"><br><br>
            <input type="submit" value="Add"><br><br>
        </form>
    </body>
</html>
