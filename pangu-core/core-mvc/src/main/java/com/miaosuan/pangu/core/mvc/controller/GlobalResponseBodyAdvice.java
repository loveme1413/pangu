package com.miaosuan.pangu.core.mvc.controller;

import com.miaosuan.pangu.core.common.common.CoreConst;
import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回值修改
 *
 * @author spy
 * @version 1.0 2019-06-19
 * @since 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof Result) {
            String requestId = MDC.get(CoreConst.MDC_REQUEST_ID);

            Result result = (Result) body;
            result.setRequestId(requestId);
        }

        return body;
    }
}
