<!DOCTYPE html>
<html>
<head>
    <title>Photos</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>

    <@resource path="${src}/xx-base/css/bootstrap.css, ${src}/xx-blog/css/style.css, ${src}/xx-base/markdown/css/editormd.css"/>
    <@resource path="${src}/xx-base/js/jquery-1.11.1.min.js"/>
</head>

<body>
<!-- banner-body -->
<div class="banner-body">
    <div class="container">
        <div class="banner-body-content">

            <#include "/xx-blog/navbar.ftl"/>

            <div class="col-xs-10 banner-body-right">

                <#include "/xx-blog/slider.ftl"/>

                <div class="banner-bottom">
                    <div class="col-md-4 banner-left">
                        <div class="col-xs-3 banner-left1">
                            <div class="banner-left11">
                                <span> </span>
                            </div>
                        </div>
                        <div class="col-xs-9 banner-right1">
                            <h3>cupidatat proi</h3>
                        </div>
                        <div class="clearfix"> </div>
                        <p>Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui.</p>
                    </div>
                    <div class="col-md-4 banner-left">
                        <div class="col-xs-3 banner-left1">
                            <div class="banner-left22">
                                <span> </span>
                            </div>
                        </div>
                        <div class="col-xs-9 banner-right1">
                            <h3>sint occaecat</h3>
                        </div>
                        <div class="clearfix"> </div>
                        <p>Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui.</p>
                    </div>
                    <div class="col-md-4 banner-left">
                        <div class="col-xs-3 banner-left1">
                            <div class="banner-left33">
                                <span> </span>
                            </div>
                        </div>
                        <div class="col-xs-9 banner-right1">
                            <h3>cupida quisu</h3>
                        </div>
                        <div class="clearfix"> </div>
                        <p>Excepteur sint occaecat cupidatat non proident,
                            sunt in culpa qui.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>


                <div class="gallery-head">
                    <h5>Photo Gallery</h5>
                    <p>But I must explain to you how all this mistaken idea of denouncing  pleasure and praising pain was born.</p>
                </div>
                <div class="gallery-grids">
                    <div class="gallery-grid">
                        <a href="${src}/xx-blog/images/7.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
                            <img src="${src}/xx-blog/images/7.jpg" alt=" " class="img-responsive" />
                        </a>
                    </div>
                    <div class="gallery-grid">
                        <a href="${src}/xx-blog/images/4.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
                            <img src="${src}/xx-blog/images/4.jpg" alt=" " class="img-responsive" />
                        </a>
                        <a href="${src}/xx-blog/images/6.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
                            <img src="${src}/xx-blog/images/6.jpg" alt=" " class="img-responsive" />
                        </a>
                    </div>
                    <div class="gallery-grid">
                        <a href="${src}/xx-blog/images/5.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
                            <img src="${src}/xx-blog/images/5.jpg" alt=" " class="img-responsive" />
                        </a>
                        <a href="${src}/xx-blog/images/8.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
                            <img src="${src}/xx-blog/images/8.jpg" alt=" " class="img-responsive" />
                        </a>
                    </div>
                    <div class="clearfix"> </div>
                </div>

                <!--script-->
                <@resource path="${src}/xx-base/js/jquery.chocolat.js"/>
                <@resource path="${src}/xx-base/css/chocolat.css"/>

                <!--light-box-files-->
                <script type="text/javascript" charset="utf-8">
                    $(function() {
                        $('.gallery-grid a').Chocolat();
                    });
                </script>
                <!--script-->

                <div class="msg-text-bottom">
                    <div class="col-md-4 msg-text-bottom-left">
                        <figure class="effect-winston">
                            <a href="single.html"><img src="${src}/xx-blog/images/4.jpg" alt=" " class="img-responsive" />
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
                            <a href="single.html"><img src="${src}/xx-blog/images/5.jpg" alt=" " class="img-responsive" />
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
                            <a href="single.html"><img src="${src}/xx-blog/images/6.jpg" alt=" " class="img-responsive" />
                                <figcaption>

                                </figcaption>
                            </a>
                        </figure>
                        <h3><a href="single.html">porro quisquam est</a></h3>
                        <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet,
                            consectetur, adipisci velit, sed quia.</p>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="clearfix"> </div>
            <#include "/xx-blog/footer.ftl"/>
        </div>
    </div>
</div>
<!-- //banner-body -->
<!-- for bootstrap working -->
<script src="${src}/xx-base/js/bootstrap.js"></script>
<!-- //for bootstrap working -->
</body>
</html>