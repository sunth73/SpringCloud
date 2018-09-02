package com.sunth.ZuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sunth
 * @DateTime 2018-09-02 20:48
 * 描述
 */
public class TestPostFilter extends ZuulFilter {
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
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        Object param=request.getParameter("param");
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
//        ctx.setResponseBody("{\"result\":\"哈喽，被拦截了哦!\"}");

        return null;
    }
}
