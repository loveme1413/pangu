package com.miaosuan.pangu.core.feign.interceptor;

import com.miaosuan.pangu.core.common.common.CoreConst;
import com.miaosuan.pangu.core.common.util.RandomUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * 模块
 *
 * @author spy
 * @version 1.0 2019-06-20
 * @since 1.0
 */
@Slf4j
public class FeignMDCInterceptor extends AbstractRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
//            HttpServletRequest request = getRequest();
//            if (request != null) {
//
//            }

            String requestId = MDC.get(CoreConst.MDC_REQUEST_ID);

            requestId = StringUtils.defaultString(requestId, RandomUtil.uuidShort());


            requestTemplate.header(CoreConst.MDC_REQUEST_ID, requestId);
        } catch (Throwable e) {
            log.error("feign mdc header设置异常", e);
        }
    }
}
