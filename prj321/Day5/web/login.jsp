<%-- 
    Document   : login
    Created on : Jun 16, 2020, 3:52:21 PM
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
        <h1>LOGIN FORM!</h1>
        <form action="loginform.do" method="post">
            Username: <input type="text" name="uname"><br>
            Password: <input type="text" name="pass">
            <input type="submit" value="submit">
        </form>
    </body>
</html>
