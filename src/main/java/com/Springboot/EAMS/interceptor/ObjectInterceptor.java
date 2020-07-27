package com.Springboot.EAMS.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class ObjectInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ObjectInterceptor.class);
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Enumeration<String> headerNames = request.getHeaderNames();

        String msg=" ";
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                msg=msg+("Header: " + request.getHeader(headerNames.nextElement()));
            }
        }
        logger.info(msg);
        return true;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        String msg = String.format("***** The Response Object is : Out -: %s Status -: %s ",response.getOutputStream().toString(),response.getStatus());
        logger.info(msg);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        System.out.println("Request and Response is completed");
    }

}
