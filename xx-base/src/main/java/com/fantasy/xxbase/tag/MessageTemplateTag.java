package com.fantasy.xxbase.tag;

import com.fantasy.xxutil.util.XXMessageUtils;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 获取国际化标签
 * eg: <@msg key="key" args="参数1,参数2"/>
 */
public class MessageTemplateTag implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {

        if(params == null) return;

        String key = params.get("key").toString();

        String args = params.get("args").toString();

        if(StringUtils.isBlank(key)) return;

        String msg;

        if(StringUtils.isBlank(args)){

            msg = XXMessageUtils.getMessage(key);

        }else{
            String[] array = StringUtils.split(",");
            msg = XXMessageUtils.getMessage(key, array);
        }

        env.getOut().write(msg);
        env.getOut().flush();
        env.getOut().close();
    }

}
