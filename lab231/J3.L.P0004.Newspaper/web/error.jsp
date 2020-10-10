<%-- 
    Document   : error
    Created on : Oct 6, 2020, 11:55:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./public/css/error-page.css" /> 
        <link rel="stylesheet" type="text/css" href="./public/css/style.css" /> 
        <title>Error</title> 
    </head>
    <body>
        <div> 
            <div class="font-sans text-blue"> 
                <%@include file="/components/header.jsp" %> 
                <div class="flex container"> 
                    <div class="left pa-5"> 
                        <p class="error">${error}</p> 
                    </div> 
                </div> 
                <footer class="footer"> 
                </footer> 
            </div> 
        </div> 
    </body>
</html>
