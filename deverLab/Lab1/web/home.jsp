<%-- 
    Document   : home
    Created on : Sep 21, 2020, 12:20:41 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div>
        <h1>Yet</h1>
        </div>
        <div id="box">
            <s:form action="short">
                <input type="text" name="originalURL" placeholder="Input your link"/>
                <button >Shorten</button><br>
                <label>Custom Link: </label>
                <p style="color: red">${error}</p> 
                <input type="text" name="custom" />
            </s:form>
        
        <br>
        <!--<form action="redirect">-->
            Shorten Link: <p name="newURL">${newURL}</p>
            <!--<button >Shorten</button><br>-->
        <!--</form>-->
        </div>
    </body>
</html>
