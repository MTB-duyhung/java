<%-- 
    Document   : menu
    Created on : Jun 16, 2020, 4:48:02 PM
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
        <div style="margin: auto; text-align: left; width: 300px">
            <font color="red">Welcome,${sessionScope.LoginActionForm.username}</font>
            <h3>Welcome to the Struts World</h3>
            <form action="search.do">
                Name <input type="text" name="name"/><br>
                <input type="submit" value="Search"/>
            </form>
        </div>
    </body>
</html>
