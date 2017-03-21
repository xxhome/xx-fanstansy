<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    }
    </script>

    <@resource path="${src}/xx-base/css/bootstrap.css, ${src}/xx-blog/css/style.css, ${src}/xx-base/markdown/css/editormd.css"/>

    <@resource path="${src}/xx-base/js/jquery-1.11.1.min.js"/>


<#--<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>-->
    <#--<link href='http://fonts.useso.com/css?family=Great+Vibes' rel='stylesheet' type='text/css'>-->
    <#--<link href='http://fonts.useso.com/css?family=Comfortaa:400,300,700' rel='stylesheet' type='text/css'>-->
</head>

<body>
<!-- banner-body -->
<div class="banner-body">
    <div class="container">
        <div class="banner-body-content">
            <div class="col-xs-2 banner-body-left" id="banner-body-left">
                <div class="logo">
                    <h1><a href="index.ftl">Great <span>Taste</span></a></h1>
                </div>
                <div class="top-nav">
                    <nav class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                    data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                            <nav class="stroke">
                                <ul class="nav navbar-nav">
                                    <li class="active"><a href="${path}/xxblog/view/index.xhtml"><i class="home"></i>主页</a></li>
                                    <li><a href="${path}/xxblog/view/blog.xhtml" class="hvr-underline-from-left"><i class="edit1"></i>博客</a></li>
                                    <li><a href="photos.html" class="hvr-underline-from-left"><i class="picture1"></i>照片</a></li>
                                    <#--<li><a href="short-codes.html" class="hvr-underline-from-left"><i class="text-size1"></i>Short Codes</a></li>-->
                                    <li><a href="mail.html" class="hvr-underline-from-left"><i class="envelope1"></i>关于</a></li>
                                </ul>
                            </nav>
                        </div>
                        <!-- /.navbar-collapse -->
                    </nav>
                </div>
            </div>
            <div class="col-xs-10 banner-body-right">
                <div class="wmuSlider example1">
                    <div class="wmuSliderWrapper">
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="banner"></div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="banner1"></div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="banner2"></div>
                            </div>
                        </article>
                    </div>
                </div>

                <script src="${src}/xx-base/js/jquery.wmuSlider.js"></script>

                <script>
                    $('.example1').wmuSlider();
                </script>


                <div class="banner-bottom">

                    <div id="test-editormd">
                        <textarea>###xxxx</textarea>
                    </div>

                    <div class="col-md-16 banner-left banner-margin">
                        <div class="col-xs-1 banner-left1">
                            <div class="banner-left11">
                                <span>  </span>
                            </div>
                        </div>
                        <div class="col-xs-10 banner-right1">
                            <h3>日志级别动态调整——小工具解决大问题</h3>
                        </div>
                        <div class="clearfix"></div>
                        <p>工欲善其事，必先利其器。一个好的工具，能够节省大量的时间，提高整体工作效率。本文主要依据一线工程师的日常工作，从使用最频繁的日志着手，介绍了如何在保障...</p>
                    </div>

                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="footer">
                <div class="footer-left">
                    <ul>
                        <li><a href="#">Privacy Policy</a>|</li>
                        <li><a href="#">Terms of Use</a>|</li>
                        <li><a href="mail.html">Contact Us</a></li>
                    </ul>
                    <p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank"</p>
                </div>
                <div class="footer-right">
                    <ul class="social-nav model-3">
                        <li><a href="#" class="icon icon-border facebook"></a></li>
                        <li><a href="#" class="icon icon-border twitter"></a></li>
                        <li><a href="#" class="icon icon-border googleplus"></a></li>
                        <li><a href="#" class="icon icon-border github"></a></li>
                        <li><a href="#" class="icon icon-border rss"></a></li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<!-- //banner-body -->

<!-- for bootstrap working -->
<@resource path="${src}/xx-base/js/bootstrap.js"/>
<@resource path="${src}/xx-blog/js/blog.js"/>
<!-- //for bootstrap working -->

<@resource path="${src}/xx-base/markdown/js/editormd.js"/>

<script type="text/javascript">

        $(function() {
            var testEditor = editormd("test-editormd", {
                width   : "100%",
                height  : 640,
                syncScrolling : "single",
                htmlDecode      : "style,script,iframe",  // you can filter tags decode
                emoji           : true,
                taskList        : true,
                tex             : true,  // 默认不解析
                flowChart       : true,  // 默认不解析
                sequenceDiagram : true,  // 默认不解析
                preview:false,
                path    : "${src}/xx-base/markdown/lib/"
            });


        });
</script>


</body>
</html>