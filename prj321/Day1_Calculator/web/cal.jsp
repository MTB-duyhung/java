<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculator!</h1>
        <hr>
        <form action="CalcultorController">
            Number 1: <input type="text" name="num1"><br><br>
            Number 2: <input type="text" name="num2"><br><br>
            <input type="submit" name="action" value="+">
            <input type="submit" name="action" value="-">
            <input type="submit" name="action" value="*">
            <input type="submit" name="action" value="/">
        </form>
    </body>
</html>
