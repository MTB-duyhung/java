<%-- 
    Document   : Login
    Created on : May 19, 2020, 3:14:20 PM
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
        <h1>LOGIN</h1>
        <form action="controller">
            Username: <input type="text" name="txtUser"/><br>
            Password: <input type="password" name="txtPass"/><br>
            <input type="submit" name="action" value="login"/>
            <a href="controller?action=new">Register New User</a>
        </form>
    </body>
</html>
