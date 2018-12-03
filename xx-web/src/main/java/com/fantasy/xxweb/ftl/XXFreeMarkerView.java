package com.fantasy.xxweb.ftl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class XXFreeMarkerView extends FreeMarkerView {

    private static final String LOCALHOST = "localhost";

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        final String contextPath = request.getContextPath();
        final String requestURL = request.getRequestURL().toString();

        //ip + port
        final String localhost = StringUtils.substringBefore(requestURL, contextPath);

        model.put(LOCALHOST, localhost + contextPath);
        super.exposeHelpers(model, request);
    }
}
