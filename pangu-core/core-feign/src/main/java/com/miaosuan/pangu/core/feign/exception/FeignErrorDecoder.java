package com.miaosuan.pangu.core.feign.exception;

import com.miaosuan.pangu.core.common.common.CoreErrorConst;
import com.miaosuan.pangu.core.common.exception.BaseAppException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * feign异常封装模块
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {
        log.error(">>>>> decode exception.");

        try {
            if (response.body() != null) {
                String body = getExceptionBody(response);
                log.error(body);
            }

            if (response.status() >= 400 && response.status() <= 500) {

                // TODO
                // return new HystrixBadRequestException("RPC调用失败");
                return new BaseAppException(CoreErrorConst.RPC_INVOKE_ERR, "RPC调用失败");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return new BaseAppException(e.getMessage());
        }

        return feign.FeignException.errorStatus(methodKey, response);
    }


    private String getExceptionBody(Response response) {
        String body = null;
        try {
            body = Util.toString(response.body().asReader());
        } catch (IOException e) {
            log.error("获取response body 流错误", e);
        }
        return body;
    }
}
