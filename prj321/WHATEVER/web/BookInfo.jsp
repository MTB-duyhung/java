<%@page import="java.util.List"%>
<%@page import="edu.fud.DAO.bookDAO"%>
<%@page import="edu.fud.model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Book Online</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="styleRead.css">
    </head>
    <body>
        <div>
            <jsp:include page="header.jsp"/>
        </div>
        <div class="bookInfo">
            <div class="bookLeft">
                <%
                    bookDAO bList = new bookDAO();
                    Book b = bList.getBook("B001");
                    out.print("<img src='"+ b.getPicture()+"'/>");
                %>
                <!--<img src="https://salt.tikicdn.com/cache/w390/media/catalog/product/t/u/tuoi-tre-dang-gia-bao-nhieu-u547-d20161012-t113832-888179.u3059.d20170616.t095744.390222.jpg">-->       
            </div>
            <div class="bookRight">
                <%                    bookDAO pList = new bookDAO();
                    Book sp = pList.getBook("B001");
                    out.print("<h3>" + sp.getTitle() + "</h3>"
                            + "Author: " + "<h7>" + sp.getAuthor() + "</h7><br/>"
                            + "Publisher: " + "<h7>" + sp.getPublisher() + "</h7><br/>"
                            + "Year: " + "<h7>" + sp.getYear() + "</h7><br/>"
                            + "Category: " + "<h7>" + sp.getCategory() + "</h7><br/>"
                            + "Language: " + "<h7>" + sp.getLanguage() + "</h7><br/>"
                            + "Preview: " + "<h7>" + sp.getPreview() + "</h7><br/>");
                %>
                <button class="btnRead" type="button" value="Read" onClick="javascript:window.location = '<%= "ReadBook.jsp"%>';">Read</button>
            </div>
            <br>
        </div>
        <div>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
