package com.miaosuan.pangu.core.mvc.interceptor;

import com.miaosuan.pangu.core.common.common.CoreConst;
import com.miaosuan.pangu.core.common.util.RandomUtil;
import com.miaosuan.pangu.core.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MDC拦截器
 *
 * @author spy
 * @version 1.0 2019-06-19
 * @since 1.0
 */
@Slf4j
public class MDCHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestId = getRequestId(request);

        MDC.put(CoreConst.MDC_REQUEST_ID, requestId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        MDC.remove(CoreConst.MDC_REQUEST_ID);
    }


    /**
     * 获取requestId
     *
     * @param request
     * @return
     */
    private String getRequestId(HttpServletRequest request) {
        String requestId = request.getHeader(CoreConst.MDC_REQUEST_ID);

        if (StringUtil.isEmpty(requestId)) {
            requestId = request.getParameter(CoreConst.PARAM_REQUEST_ID);
        }
        requestId = StringUtils.defaultString(requestId, RandomUtil.uuidShort());

        return requestId;
    }
}
