<%-- 
    Document   : index
    Created on : Jun 16, 2020, 4:27:51 PM
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
        <div style="margin: auto;text-align: left; width: 200px">
            <h1>LOGIN PAGE!</h1>
            <form action="login.do" method="POST">
                Username: <input type="text" name="username" value=""/></br>
                Password: <input type="password" name="password" value=""/></br>
                <input type="submit" value="Login"/>
                <input type="reset" value="Reset"/>
            </form>
        </div>
    </body>
</html>
