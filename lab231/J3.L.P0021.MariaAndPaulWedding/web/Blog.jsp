<%-- 
    Document   : Blog
    Created on : Oct 21, 2020, 2:39:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="header.jsp" %>

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper blog">
                                <div class="content">
                                    <div class="section">
                                        <div class="content">
                                            <div class="item">
                                                <div class="controls">
                                                    <span class="date-text">${blog.getDate()}</span>
                                                </div>
                                                <div class="heading">
                                                    <h4>${blog.getTitle()}</h4>
                                                </div>

                                                <div class="content">
                                                    <div class="img-simple span6 pull-left">
                                                        <div class="image">
                                                            <a rel="nofollow" data-ss="imagemodal" data-href="${blog.getImg()}"><img src="${blog.getImg()}"></a>
                                                        </div>
                                                    </div>

                                                    <p><span style="font-size: 16px;">${blog.getContent()}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <ul class="pager">
                                        <li><a rel="nofollow" href="http://www.simplesite.com/us-123wedding/146238995?overview=1">Overview</a></li>
                                    </ul>
                                </div>


                            </div>
                        </div>
                        <div id="right" class="span3">
                            <div class="sidebar">
                                <div class="wrapper share-box">
                                    <div class="heading">
                                        <h4>Share this page</h4>
                                    </div>

                                    <div class="content"><span><ul>
                                                <li><a id="share-facebook" href="http://www.simplesite.com/us-123wedding#"><i class="icon-facebook-sign"></i><span>Share on Facebook</span></a></li>
                                                <li><a id="share-twitter" href="http://www.simplesite.com/us-123wedding#"><i class="icon-twitter-sign"></i><span>Share on Twitter</span></a></li>
                                                <li><a id="share-google-plus" href="http://www.simplesite.com/us-123wedding#"><i class="icon-google-plus-sign"></i><span>Share on Google+</span></a></li>    
                                            </ul></span></div>
                                </div>
                            </div>
                        </div>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
