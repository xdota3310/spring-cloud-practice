package com.cloudzuul.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月12日
 */
public class AccessFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("send {} request to{}", request.getMethod(), request.getRequestURL().toString());
//        Object accessToken = request.getParameter("accessToken");
        String accessToken =request.getHeader("Authorization");
        if (accessToken == null||accessToken.equals("")) {
            accessToken = request.getHeader("token");
        }
        if(accessToken == null||accessToken.equals("")){

        }
        LOGGER.info("access is ok");
        return null;
    }
}
