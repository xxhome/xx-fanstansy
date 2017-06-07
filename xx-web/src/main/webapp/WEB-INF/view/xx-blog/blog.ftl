<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>

    <@resource base="${src}/xx-base" path="/bootstrap/css/bootstrap.css, /font-awesome/css/font-awesome.min.css"/>
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

                <div class="banner-bottom">

                    <#list [1,2,3,4,5,6,7,9] as e>
                        <a href="${path}/xxblog/view/context.xhtml">
                            <div class="col-md-6 banner-left banner-top banner-height">
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

                    <nav style="float: right;">
                        <ul class="pagination pagination-lg">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">上一页</span>
                                </a>
                            </li>
                            <li class="active"><a href="#">1</a></li>
                            <li class="disabled"><a href="#">2</a></li>
                            <li class="disabled"><a href="#">3</a></li>
                            <li class="disabled"><a href="#">4</a></li>
                            <li class="disabled"><a href="#">5</a></li>
                            <li class="disabled">
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">下一页</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>

            </div>
            <div class="clearfix"></div>

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