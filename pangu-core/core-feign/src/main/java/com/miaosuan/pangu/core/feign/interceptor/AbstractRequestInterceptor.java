package com.miaosuan.pangu.core.feign.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 模块
 *
 * @author spy
 * @version 1.0 2019-06-20
 * @since 1.0
 */
@Slf4j
public abstract class AbstractRequestInterceptor {

    protected HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
