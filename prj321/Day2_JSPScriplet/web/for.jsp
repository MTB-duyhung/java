<%-- 
    Document   : for
    Created on : May 26, 2020, 1:20:30 PM
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
        <form name="for_n" method="get">
            Nhap n: <input type="text" name="soluong"><br><br>
            <input type="submit" name="bt" value="Phat sinh"><br><br>
            <%
                String s=request.getParameter("soluong");
                if(s!=null){
                    int n=Integer.parseInt(s);
                    for (int i = 0; i < n; i++) {
                        out.print("<b>"+i+"</b>");
                        out.print("<br>");
}
                }else{
                    out.print("<b>Nhap lai n!!!</b>");
                }
               %>
        </form>
    </body>
</html>
