<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- saved from url=(0045)http://us-123charity.simplesite.com/422328013 -->
<html lang="en-US" class="">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Our School - us-123charity.simplesite.com</title>
        <meta property="og:site_name" content="Children&#39;s Charity">
        <meta property="article:publisher" content="https://www.facebook.com/simplesite">
        <meta property="og:locale" content="en-US">
        <meta property="og:url" content="http://us-123charity.simplesite.com/422328013">
        <meta property="og:title" content="About Our School">
        <meta property="og:description" content="
              Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip
              ex ea commodo consequat. Duis autem vel eum iriur...">
        <meta property="og:image" content="http://cdn.simplesite.com/i/d2/f3/285415634679428050/i285415639381953159._szw1280h1280_.jpg">
        <meta property="og:updated_time" content="2017-01-04T04:31:56.3193621+00:00">
        <meta property="og:type" content="website">
        <meta name="robots" content="nofollow">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Children&#39;s Charity - http://us-123charity.simplesite.com/">
        <link rel="stylesheet" type="text/css" href="./About Our School_files/9767413.design.v27169.css">
        <link rel="canonical" href="http://us-123charity.simplesite.com/422328013">
        <link rel="apple-touch-icon" sizes="57x57" href="http://us-123charity.simplesite.com/apple-touch-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="http://us-123charity.simplesite.com/apple-touch-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="http://us-123charity.simplesite.com/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="http://us-123charity.simplesite.com/apple-touch-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="http://us-123charity.simplesite.com/apple-touch-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="http://us-123charity.simplesite.com/apple-touch-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="http://us-123charity.simplesite.com/apple-touch-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="http://us-123charity.simplesite.com/apple-touch-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="http://us-123charity.simplesite.com/apple-touch-icon-180x180.png">
        <link rel="icon" sizes="194x194" href="http://us-123charity.simplesite.com/favicon-194x194.png">
        <link rel="icon" sizes="192x192" href="http://us-123charity.simplesite.com/android-chrome-192x192.png">
        <link rel="manifest" href="http://us-123charity.simplesite.com/manifest.json">
        <link rel="manifest" href="http://us-123charity.simplesite.com/yandex-browser-manifest.json">
        <script type="text/javascript" async="" src="./About Our School_files/analytics.js.download"></script>
        <script async="" src="./About Our School_files/gtm.js.download"></script><script type="text/javascript" src="./About Our School_files/FrontendAppLocalePage.aspx"></script>
        <script type="text/javascript" src="./About Our School_files/frontendApp.min.js.download"></script>
        <script type="text/javascript">if (typeof window.jQuery == "undefined") {
                (function () {
                    var a = document.createElement("script");
                    a.type = "text/javascript";
                    a.src = "/c/js/version3/frontendApp/init/frontendApp.min.js?_v=c3745b49b3583731aea941058c4b63a8";
                    document.getElementsByTagName('head')[0].appendChild(a);
                })();
            }</script>

        <script type="text/javascript">var css_simplesite_com_fallback_element = document.getElementById('css_simplesite_com_fallback');
            if (typeof css_simplesite_com_fallback_element !== 'undefined' && css_simplesite_com_fallback_element !== null) {
                var isVisible = css_simplesite_com_fallback_element.offsetParent !== null
                if (isVisible) {
                    var head = document.head, link = document.createElement('link');

                    link.type = 'text/css';
                    link.rel = 'stylesheet';
                    link.href = '{/d/designs/9767413.design.v27169.css}';

                    head.appendChild(link);
                }
            }</script>
        <style type="text/css">.fancybox-margin{margin-right:17px;}</style></head>
    <body data-pid="422328013" data-iid="">

        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->

            <%@include file="header.jsp" %>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <c:forEach items="${list}" var="c">
                                    <div class="section article">
                                        <style>    .wordwrapfix {
                                                word-wrap:break-word;
                                            }
                                        </style>
                                        <div class="heading wordwrapfix">
                                            <h3>${c.getTitle()}</h3>
                                        </div>

                                        <div class="content">
                                            <div class="img-simple span6 pull-right">
                                                <div class="image">
                                                    <a rel="nofollow" data-ss="imagemodal" data-href="${c.getImg()}"><img src="${c.getImg()}"></a>
                                                </div>
                                            </div>
                                            <p><span>${c.getContent()}</span></p>    </div>
                                    </div>
                                    </c:forEach>
<!--                                    <div class="section article">
                                        <style>    .wordwrapfix {
                                                word-wrap:break-word;
                                            }
                                        </style>
                                        <div class="heading wordwrapfix">
                                            <h3>Volunteers</h3>
                                        </div>

                                        <div class="content">
                                            <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait
                                                nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>    </div>
                                    </div>-->
                                </div>


                            </div>
                        </div>
                        <div id="right" class="span3">
                            <div class="sidebar">
                                <div class="wrapper share-box">
                                    <style>    .wordwrapfix {
                                            word-wrap:break-word;
                                        }
                                    </style>
                                    <div class="heading wordwrapfix">
                                        <h4>Share this page</h4>
                                    </div>

                                    <div class="content"><span><ul>
                                                <li><a id="share-facebook" href="http://us-123charity.simplesite.com/422328013#"><i class="icon-facebook-sign"></i><span>Share on Facebook</span></a></li>
                                                <li><a id="share-twitter" href="http://us-123charity.simplesite.com/422328013#"><i class="icon-twitter-sign"></i><span>Share on Twitter</span></a></li>
                                                <li><a id="share-google-plus" href="http://us-123charity.simplesite.com/422328013#"><i class="icon-google-plus-sign"></i><span>Share on Google+</span></a></li>    
                                            </ul></span></div>
                                </div>
                                <div class="wrapper viral-box">
                                    <style>    .wordwrapfix {
                                            word-wrap:break-word;
                                        }
                                    </style>
                                    <div class="heading wordwrapfix">
                                        <h4>Create a website</h4>
                                    </div>

                                    <div class="content">
                                        <p>Everybody can create a website, it's easy.</p>
                                        <div class="bottom">
                                            <a rel="nofollow" href="http://www.simplesite.com/pages/receive.aspx?partnerkey=123i%3arightbanner&amp;referercustomerid=15831186&amp;refererpageid=422328013" class="btn btn-block">Try it for FREE now</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="footer.jsp" %>
        </div>


        <input type="hidden" id="anti-forgery-token" value="vFZIp11QDd7w1cZjYdzwVVw3rTHgQi1lpMMqomvLq/qGfx85dADIn6rd+jb5+yvdIjnIKNejlFu6vxL7J8Np5e7g5yrI36losWXJkOuv169s22+Z/mKVySX+8iBmNTzgEHnWy/7MRLoBekjH3EpgI99d772eCmdJN7eG7tAqc/m4iWFE2sfSH8oY0Q3pJZcuhjM+blA+FzGTkoYvuddklk1q/4A0667VqYWgFZ7hNc8NO4Kw1Txa422/7pYh/UW67W3GdGTPhdbiuy5yZG8PFfcV3pshO8MZJZI4QqpmoSmbtrQpm9WTX4MbCbnQyM7h5NaUS9oN6X4rtQXeQ4JVwDzgCfuolg6kJOxKEjNy3wz2WXZRbIsB2tTp4Wbn2z/LBBA4iA+tWh+63StJhg7u9jc2a4qw9sJfWyKphG3y85vbnAVQqUqmzkIS9uKz31UBzSozvD8BAgNQEYpuvoNwgA==">


        <script>
            dataLayer = [{"SiteVer": "US", "MainOrUser": "UserPage", "PreOrFre": "Free", "Language": "en", "Culture": "en-US", "Instrumentation": "ShowPage", "Market": "DK"}];
        </script>
        <!-- Google Tag Manager -->
        <noscript>&lt;iframe src="//www.googletagmanager.com/ns.html?id=GTM-2MMH"
        height="0" width="0" style="display:none;visibility:hidden"&gt;&lt;/iframe&gt;</noscript>
        <script>(function (w, d, s, l, i) {
                {
                    w[l] = w[l] || [];
                    w[l].push({'gtm.start':
                                new Date().getTime(), event: 'gtm.js'});
                    var f = d.getElementsByTagName(s)[0],
                            j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
                    j.async = true;
                    j.src =
                            '//www.googletagmanager.com/gtm.js?id=' + i + dl;
                    f.parentNode.insertBefore(j, f);
                }
            })(window, document, 'script', 'dataLayer', 'GTM-2MMH');</script>
        <!-- End Google Tag Manager -->


        <!-- Remove after blog exp concludes -->

        <div id="sm2-container" class="movieContainer high_performance" style="z-index: 10000; position: fixed; width: 8px; height: 8px; bottom: 0px; left: 0px; overflow: hidden; visibility: hidden;"><embed name="sm2movie" id="sm2movie" src="/Images/sm297/soundmanager2_flash9.swf" quality="high" allowscriptaccess="always" bgcolor="#ffffff" pluginspage="www.macromedia.com/go/getflashplayer" title="JS/Flash audio component (SoundManager 2)" type="application/x-shockwave-flash" wmode="transparent" haspriority="true"></div><div style="display: none; visibility: hidden;"><script type="text/javascript">var google_conversion_id = 1066686464, google_custom_params = window.google_tag_params, google_remarketing_only = !0;</script>
            <script type="text/javascript" src="./About Our School_files/conversion.js.download"></script><iframe name="google_conversion_frame" title="Google conversion frame" width="300" height="13" src="./About Our School_files/saved_resource.html" frameborder="0" marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true" scrolling="no"></iframe>
            <noscript></noscript>
        </div>
    </body>
</html>