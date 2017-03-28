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

            <#include "/xx-blog/navbar.ftl"/>

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

            <!--
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
            -->

            <div class="clearfix"></div>
            <#include "/xx-blog/footer.ftl"/>

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