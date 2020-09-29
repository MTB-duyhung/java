<%-- 
    Document   : Edit
    Created on : Jul 19, 2020, 8:33:35 PM
    Author     : Admin
--%>
<%@page import="edu.fud.controller.ListGroupActionSupport"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit a Contact</h1>
        <h5 style="color: red">${error}</h5>
        <form action="editsubmit">
            <table border="1">
                
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>
                            <input type="text" name="id" value="${co.id}" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td>
                            <input type="text" name="fir" value="${co.firstname}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>
                            <input type="text" name="las" value="${co.lastName}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Group</td>
                        <td>
                            <select name="group">
                                <c:forEach var="i" items="<%=ListGroupActionSupport.dsn%>">    
                                    <option value="${i.ID}">${i.groupname}</option>
                                </c:forEach>         
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td>
                            <input type="text" name="phone" value="${co.phone}" />                        
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Edit"/>
            <a href="list">
                    <input type="button" value="Return To Contact List" />
            </a>
        </form>
    </body>
</html>
