package com.xxbase.tag;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author li.fang
 * @sine 17/03/10
 */
public class ResourceTemplateTag implements TemplateDirectiveModel {

    private boolean isDevModel;
    private static final long VERSION = System.currentTimeMillis();

    @Override
    public void execute(Environment env, Map map, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody)
            throws TemplateException, IOException {

        if (map == null) return;

        String paths = map.get("path").toString();
        String[] resources = StringUtils.split(paths, ",");

        long version = getIsDevModel() ? System.currentTimeMillis() : VERSION;

        StringBuffer sb = new StringBuffer();
        for(String path : resources) {

            path = StringUtils.trim(path);

            if (StringUtils.endsWithIgnoreCase(path, "js")) {

                //<script src="/js/jquery-1.11.1.min.js" type="text/javascript"/>
                sb.append("\t<script src=\"").append(path)
                        .append("?version=").append(version)
                        .append("\" ")
                        .append("type=\"text/javascript\"></script>\n");
            } else {

                //<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
                sb.append("\t<link href=\"").append(path)
                        .append("?version=").append(version)
                        .append("\" ")
                        .append("rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\n");
            }
        }

        env.getOut().write(sb.toString());
        env.getOut().flush();
    }

    public boolean getIsDevModel() {
        return isDevModel;
    }

    public void setIsDevModel(String isDevModel) {
        this.isDevModel = Boolean.valueOf(isDevModel);
    }
}
