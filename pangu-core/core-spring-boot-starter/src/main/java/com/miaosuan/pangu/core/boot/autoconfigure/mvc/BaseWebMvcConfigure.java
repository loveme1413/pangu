package com.miaosuan.pangu.core.boot.autoconfigure.mvc;

import com.miaosuan.pangu.core.boot.autoconfigure.PanguProperties;
import com.miaosuan.pangu.core.mvc.interceptor.MDCHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * 针对API请求路径增加MDC log id
 *
 * @author spy
 * @version 1.0 2019-06-19
 * @since 1.0
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "pangu", name = "web.mdc-handler-interceptor.enable", havingValue = "true", matchIfMissing = true)
public class BaseWebMvcConfigure implements WebMvcConfigurer {

    @Bean
    @ConditionalOnClass(MDCHandlerInterceptor.class)
    @ConditionalOnMissingBean(MDCHandlerInterceptor.class)
    public MDCHandlerInterceptor mdcHandlerInterceptor() {
        return new MDCHandlerInterceptor();
    }


    @Autowired
    PanguProperties panguProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] pathList = null;

        if (panguProperties.getWeb() != null) {
            pathList = panguProperties.getWeb().getMdcHandlerInterceptor().getPathList();
        }

        if (pathList == null) {
            pathList = new String[]{"/api/**"};
        }

        log.info("web mdc handler interceptor path list={}", Arrays.asList(pathList));

        registry.addInterceptor(mdcHandlerInterceptor())
                .addPathPatterns(pathList);
    }
}
