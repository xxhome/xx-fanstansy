<!DOCTYPE html>
<html>
<head>
    <title>Home</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>

    <@resource base="${src}/xx-base" path="/bootstrap/css/bootstrap.css, /markdown/css/editormd.css"/>
    <@resource base="${src}/xx-blog" path="/css/style.css"/>
    <@resource base="${src}/xx-base" path="/js/jquery-1.11.1.min.js"/>

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
                                    <h3>Standard tab panel created on bootstrap using nav-tabs</h3>
                                </div>
                                <div class="tab-pane" id="2">
                                    <h3>Notice the gap between the content and tab after applying a background color</h3>
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