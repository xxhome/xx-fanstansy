package com.fantasy.xxbase.tag;

import com.fantasy.xxbase.method.XXResponseBody;
import com.fantasy.xxutil.util.XXHttpUtils;
import com.fantasy.xxutil.util.XXJsonUtils;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author li.fang
 * @since 2017/6/5
 */
public class RequestTemplateTag implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {

        if(params == null) return;

        String url = params.getOrDefault("url", "").toString();

        if(StringUtils.isBlank(url)) return;

        String result = XXHttpUtils.get(url);

        if(StringUtils.isBlank(result)) return;

        if(XXJsonUtils.isJsonStr(result, XXResponseBody.class)){
            env.setVariable("responseBody", new BeansWrapperBuilder(Configuration.VERSION_2_3_23).build().wrap(result));
            body.render(env.getOut());
            env.getOut().flush();
        }
    }
}
