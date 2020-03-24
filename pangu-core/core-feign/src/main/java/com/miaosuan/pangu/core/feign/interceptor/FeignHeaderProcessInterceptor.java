package com.miaosuan.pangu.core.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * feign header  interceptor
 *
 * @author spy
 * @version 1.0 2019-06-19
 * @since 1.0
 */
@Slf4j
public class FeignHeaderProcessInterceptor extends AbstractRequestInterceptor
        implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            HttpServletRequest request = getRequest();
            if (request != null) {
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String values = request.getHeader(name);
                        requestTemplate.header(name, values);
                    }
                }
            }
        } catch (Throwable e) {
            //skip
            log.error("feign header设置异常", e);
        }
    }


}