package com.lr.cloudadmin.common.interceptor;

import com.lr.cloudadmin.common.config.Audience;
import com.lr.cloudadmin.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月15日
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Autowired
    private Audience audience;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        final String authHeader = request.getHeader("authorization");
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        } else {
            if (null == authHeader || !authHeader.startsWith("bearer;")) {
//                throw new ServiceRuntimeException(new ErrorDetails(1004));

            }
        }
        final String token = authHeader.substring(7);
        try {
            final Claims claims = JwtUtil.parseJWT(token, audience.getBase64Secret());
            if (claims == null) {
//                throw new ServiceRuntimeException(new ErrorDetails(1004));
            }
            request.setAttribute("CLAIMS", claims);
            return true;
        } catch (final Exception e) {
//            throw new ServiceRuntimeException(new ErrorDetails(1004));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }



    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)  {

    }

}
