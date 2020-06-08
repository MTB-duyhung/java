<%-- 
    Document   : helloEL
    Created on : Jun 2, 2020, 1:03:15 PM
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
        <ul>
            <li>5+6=${5+6}</li>
            <li>5-6=${5-6}</li>
            <li>5/6=${5/6}</li>
            <li>5*6=${5*6}</li>
            <li>Name: ${param.name}</li>
            <li>Age: ${param.age}</li>
        </ul>
    </body>
</html>
