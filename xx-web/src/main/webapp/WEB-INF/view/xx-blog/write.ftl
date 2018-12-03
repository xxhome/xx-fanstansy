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
                        <div id="editormd-view1">
                            <textarea style="display:none;" name="test-editormd-markdown-doc"></textarea>
                        </div>

                        <div id="editormd-view2">
                            <textarea style="display:none;" name="test-editormd-markdown-doc"></textarea>
                        </div>

                        <div id="editormd-view3">
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
            testEditor = editormd("editormd-view1", {
                width: "100%",
                height: 80,
                watch:false,
                syncScrolling: "single",
                theme: "dark",
                placeholder:"这里输入文章标题......",
                path: "${src}/xx-base/markdown/lib/",
                toolbarIcons : function() {
                    return ["preview"];
                }
            });
        });

        $(function () {
            testEditor = editormd("editormd-view2", {
                width: "100%",
                height: 300,
                watch:false,
                syncScrolling: "single",
                theme: "dark",
                placeholder:"这里输入文章标题......",
                path: "${src}/xx-base/markdown/lib/",
                toolbarIcons : function() {
                    return ["preview"];
                }
            });
        });

        $(function () {
            testEditor = editormd("editormd-view3", {
                width: "100%",
                height: 500,
                watch:false,
                syncScrolling: "single",
                theme: "dark",
                placeholder:"这里输入文章标题......",
                path: "${src}/xx-base/markdown/lib/",
                toolbarIcons : function() {
                    return ["preview"];
                }
            });
        });
    </script>

</body>
</html>