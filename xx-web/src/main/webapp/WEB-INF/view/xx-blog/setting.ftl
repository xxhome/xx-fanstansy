<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>

    <@resource base="${src}/xx-base" path="/bootstrap/css/bootstrap.css, /markdown/css/editormd.css"/>
    <@resource base="${src}/xx-blog" path="/css/style.css"/>
    <@resource base="${src}/xx-base" path="/js/jquery-1.11.1.min.js"/>

    <link href="${src}/xx-blog/favicon.ico" rel="icon" type="image/x-icon" />

</head>

<body>
    <!-- banner-body -->
    <div class="banner-body">
        <div class="container">
            <div class="banner-body-content">
                <#include "/xx-blog/navbar.ftl"/>

                    <div class="col-xs-10 banner-body-right">
                        <div class="banner-bottom banner-top">
                            <ul class="nav nav-tabs">
                                <li class="active">
                                    <a  href="#1" data-toggle="tab">个人信息</a>
                                </li>
                                <li><a href="#2" data-toggle="tab">博客设置</a>
                                </li>
                                <li><a href="#3" data-toggle="tab">相册设置</a>
                                </li>
                            </ul>

                            <div class="tab-content">

                                <div class="tab-pane active" id="1">

                                    <div class="panel panel-default panel-box" style="width: 50%;min-height: 500px;">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">头像设置</h3>
                                        </div>
                                        <div class="panel-body" style="text-align: center;">
                                            <img src="${src}/xx-blog/images/icon_mg.png">
                                        </div>
                                    </div>

                                </div>

                                <div class="tab-pane" id="2">

                                    <div class="panel panel-default panel-box" style="width: 50%;min-height: 500px;">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">博客分类</h3>
                                        </div>
                                        <div class="panel-body" style="text-align: center;">
                                            <img src="${src}/xx-blog/images/icon_mg.png">
                                        </div>
                                    </div>

                                </div>

                                <div class="tab-pane" id="3">
                                    <h3>add clearfix to tab-content (see the css)</h3>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="clearfix"></div>
                <#include "/xx-blog/footer.ftl"/>
            </div>
        </div>
    </div>
    <!-- //banner-body -->

    <!-- for bootstrap working -->
    <@resource path="${src}/xx-base/bootstrap/js/bootstrap.js"/>
    <!-- //for bootstrap working -->


</body>
</html>