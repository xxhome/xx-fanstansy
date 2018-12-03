<!DOCTYPE HTML>
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

    <link href="${src}/xx-blog/favicon.ico" rel="icon" type="image/x-icon" />${requestURL}
</head>

<body>
<!-- banner-body -->
<div class="banner-body">
    <div class="container">
        <div class="banner-body-content">

            <#include "/xx-blog/navbar.ftl"/>

            <div class="col-xs-10 banner-body-right">

                <div class="banner-bottom">

                    <@http url="${path}/xxblog/content/list.xhtml">
                        <#assign json=responseBody?eval/>
                        <#list json.data as content>
                            <a href="${path}/xxblog/view/context.xhtml?id=${content.id}">
                                <div class="col-md-6 banner-left banner-top banner-height">
                                    <div class="col-xs-1 banner-left1">
                                        <div class="banner-left11">
                                            <span>  </span>
                                        </div>
                                    </div>
                                    <div class="col-xs-10 banner-right1">
                                        <h3>${content.name}</h3>
                                    </div>
                                    <div class="clearfix"></div>
                                    <p>${content.description}</p>

                                    <div class="bootstrap-tagsinput tags-list">
                                        <#list content.tags as tag>
                                            <span class="tag label tag-label-info">${tag.name}<span data-role="remove"></span></span>
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
                    </@http>

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