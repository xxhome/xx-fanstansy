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

    <link href="${src}/xx-blog/favicon.ico" rel="icon" type="image/x-icon"/>
</head>

<body>
    <!-- banner-body -->
    <div class="banner-body">
        <div class="container">
            <div class="banner-body-content">
            <#include "/xx-blog/navbar.ftl"/>

                <div class="col-xs-10 banner-body-right">
                    <div class="banner-bottom">
                        <div id="editormd-view">
                            <textarea style="display:none;" name="test-editormd-markdown-doc"></textarea>
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
    <@resource base="${src}/xx-base/bootstrap" path="/js/bootstrap.js"/>
    <@resource path="${src}/xx-base/markdown/js/editormd.js"/>
    <!-- //for bootstrap working -->

    <script type="text/javascript">
        var testEditor;

        $(function () {
            testEditor = editormd("editormd-view", {
                width: "100%",
                height: 1050,
                syncScrolling: "single",
                path: "${src}/xx-base/markdown/lib/"
            });
        });
    </script>

</body>
</html>