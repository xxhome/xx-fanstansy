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

    <@resource path="${src}/xx-base/css/bootstrap.css, ${src}/xx-blog/css/style.css"/>

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
                                    <li><a href="${path}/xxblog/view/blog.xhtml" class="hvr-underline-from-left"><i
                                            class="edit1"></i>博客</a></li>
                                    <li><a href="photos.html" class="hvr-underline-from-left"><i class="picture1"></i>照片</a>
                                    </li>
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

                    <#list [1,2,3,4,5,6,7,9] as e>
                        <a href="${path}/xxblog/view/context.xhtml">
                            <div class="col-md-6 banner-left banner-margin">
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

                                <div class="bootstrap-tagsinput tags-list">
                                    <#list [1,2,3,4,5] as t>
                                        <span class="tag label tag-label-info">Amsterdam<span data-role="remove"></span></span>
                                    </#list>
                                </div>

                                <div class="banner-footer">
                                    <span>莫某 发布于 2小时前</span>
                                    <span>阅读(1000)</span>
                                    <span>点赞(2)</span>
                                </div>
                            </div>
                        </a>
                    </#list>

                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="col-xs-2 banner-body-left">
                <div class="latest-news">
                    <h2>博客分类</h2>
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                       aria-expanded="true" aria-controls="collapseOne">
                                        Michael Vol
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                                 aria-labelledby="headingOne">
                                <div class="panel-body">
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingTwo">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        Andrew Rich
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="headingTwo">
                                <div class="panel-body">
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingThree">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        Rita Rock
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="headingThree">
                                <div class="panel-body">
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry.
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="join">
                        <a href="single.html">Learn More</a>
                    </div>
                    <h3>Benefits</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                        laudantium.</p>
                </div>
            </div>
            <div class="col-xs-9 banner-body-right">
                <div class="msg-text">
                    <div class="col-xs-2 msg-text-left">
                        <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                    </div>
                    <div class="col-xs-10 msg-text-right">
                        <p>Do one thing, and do it well.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="msg-text-bottom">
                    <div class="col-md-4 msg-text-bottom-left">
                        <figure class="effect-winston">
                            <a href="single.xhtml"><img src="${src}/xx-blog/images/4.jpg" alt=" " class="img-responsive"/>
                                <figcaption>

                                </figcaption>
                            </a>
                        </figure>

                        <h3><a href="single.html">vel illum qui dolorem</a></h3>
                        <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet,
                            consectetur, adipisci velit, sed quia.</p>
                    </div>
                    <div class="col-md-4 msg-text-bottom-left">
                        <figure class="effect-winston">
                            <a href="single.html"><img src="${src}/xx-blog/images/5.jpg" alt=" " class="img-responsive"/>
                                <figcaption>

                                </figcaption>
                            </a>
                        </figure>
                        <h3><a href="single.html">quia dolor sit amet</a></h3>
                        <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet,
                            consectetur, adipisci velit, sed quia.</p>
                    </div>
                    <div class="col-md-4 msg-text-bottom-left">
                        <figure class="effect-winston">
                            <a href="single.html"><img src="${src}/xx-blog/images/6.jpg" alt=" " class="img-responsive"/>
                                <figcaption>

                                </figcaption>
                            </a>
                        </figure>
                        <h3><a href="single.html">porro quisquam est</a></h3>
                        <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet,
                            consectetur, adipisci velit, sed quia.</p>
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

</body>
</html>