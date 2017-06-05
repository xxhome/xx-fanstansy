package com.fantasy.xxbase.tag;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Map;

/**
 * @author li.fang
 * @sine 17/03/10
 */
public class ResourceTemplateTag implements TemplateDirectiveModel {

    @Value(value = "${system.is_dev_mode}")
    public String isDevMode;

    private static final long VERSION = System.currentTimeMillis();

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody)
            throws TemplateException, IOException {

        if (map == null) return;

        String base = map.getOrDefault("base", "").toString();
        String paths = map.getOrDefault("path", "").toString();
        String[] resources = StringUtils.split(paths, ",");

        long version = getIsDevMode() ? System.currentTimeMillis() : VERSION;

        StringBuffer sb = new StringBuffer();
        for(String path : resources) {

            path = StringUtils.trim(path);

            if (StringUtils.endsWithIgnoreCase(path, "js")) {

                //<script src="/js/jquery-1.11.1.min.js" type="text/javascript"/>
                sb.append("\t<script src=\"")
                        .append(base)
                        .append(path)
                        .append("?version=").append(version)
                        .append("\" ")
                        .append("type=\"text/javascript\"></script>\n");
            } else {

                //<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
                sb.append("\t<link href=\"")
                        .append(base)
                        .append(path)
                        .append("?version=").append(version)
                        .append("\" ")
                        .append("rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\n");
            }
        }

        env.getOut().write(sb.toString());
        env.getOut().flush();
    }

    public boolean getIsDevMode() {
        return Boolean.valueOf(isDevMode);
    }

    public void setIsDevMode(String isDevMode) {
        this.isDevMode = isDevMode;
    }
}
