<!DOCTYPE HTML>

<div class="col-xs-2 banner-body-left" id="banner-body-left">
    <div class="logo">
        <h1><a href="index.xhtml">Great <span>Taste</span></a></h1>
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

                        <@http url="${path}/xxblog/menu/list.xhtml">
                            <#assign json=responseBody?eval />
                            <#list json.data as menu>
                                <li class="${(active?default("home")==menu.mark)?string('active', '')}">
                                    <a href="${path}${menu.url}?active=${menu.mark}" class="hvr-underline-from-left">
                                        <i class="${menu.glyphicon}"></i>${menu.name}
                                    </a>
                                </li>
                            </#list>
                        </@http>

                    </ul>
                </nav>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

    </div>



    <div class="latest-news">
        <h2>博客分类</h2>
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div id="panel-list-group">
                <div class="panel list-group">

                    <@http url="${path}/xxblog/group/list.xhtml">
                        <#assign json=responseBody?eval />
                        <#if json.code == 0>
                            <#list json.data as item>
                                <a href="javascript:void(0)" class="list-group-item nav-list-group-item glyphicon glyphicon-tags" data-toggle="collapse" data-target="#sm-${item.id}" data-parent="#panel-list-group">
                                    ${item.name}
                                </a>
                                <div id="sm-${item.id}" class="sublinks collapse">
                                    <a class="list-group-item nav-list-group-item sub-nav-list-group-item" href="#"><span class="glyphicon glyphicon glyphicon-link"></span> inbox</a>
                                    <a class="list-group-item nav-list-group-item sub-nav-list-group-item" href="#"><span class="glyphicon glyphicon glyphicon-link"></span> sent</a>
                                </div>
                            </#list>
                        </#if>
                    </@http>

                </div>
            </div>

            <#--<div class="panel list-group">-->
                <#--<a href="#" class="list-group-item" data-toggle="collapse" data-target="#sm" data-parent="#menu">MESSAGES <span class="label label-info">5</span> <span class="glyphicon glyphicon-envelope pull-right"></span></a>-->
                <#--<div id="sm" class="sublinks collapse">-->
                    <#--<a class="list-group-item small"><span class="glyphicon glyphicon-chevron-right"></span> inbox</a>-->
                    <#--<a class="list-group-item small"><span class="glyphicon glyphicon-chevron-right"></span> sent</a>-->
                <#--</div>-->
                <#--<a href="#" class="list-group-item" data-toggle="collapse" data-target="#sl" data-parent="#menu">TASKS <span class="glyphicon glyphicon-tag pull-right"></span></a>-->
                <#--<div id="sl" class="sublinks collapse">-->
                    <#--<a class="list-group-item small"><span class="glyphicon glyphicon-chevron-right"></span> saved tasks</a>-->
                    <#--<a class="list-group-item small"><span class="glyphicon glyphicon-chevron-right"></span> add new task</a>-->
                <#--</div>-->
                <#--<a href="#" class="list-group-item">ANOTHER LINK ...<span class="glyphicon glyphicon-stats pull-right"></span></a>-->
            <#--</div>-->
            <#--
            <@http url="http://127.0.0.1/xx-fantasy/xxblog/group/list.xhtml">
                <#assign json=responseBody?eval />
                <#if json.code == 0>
                    <#list json.data as item>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#${item.id}" aria-expanded="true" aria-controls="collapseOne">
                                        ${item.name}
                                    </a>
                                </h4>
                            </div>
                            <div id="${item.id}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry.
                                </div>
                            </div>
                        </div>
                    </#list>
                </#if>
            </@http>
            -->
        </div>
        <!--
        <div class="join">
            <a href="single.html">Learn More</a>
        </div>
        -->
        <h3>心灵鸡汤</h3>
        <p style="text-indent:28px">
            站在时光的路口回望曾经，盘点每一份经历过的心情，人生有太多得不到的美好，有太多想不到的结局。终有一天，我们热望过的，贪念过的，彷徨过的，握紧过的，放手过的，都将化作尘埃随风飞去.
        </p>
        <span style="float: right;color:#999;">
            -- ${date?substring(0, 10)}
        </span>
    </div>
</div>