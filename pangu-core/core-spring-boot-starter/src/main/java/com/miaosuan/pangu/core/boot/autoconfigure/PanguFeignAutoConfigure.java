package com.miaosuan.pangu.core.boot.autoconfigure;

import com.miaosuan.pangu.core.feign.exception.FeignErrorDecoder;
import com.miaosuan.pangu.core.feign.interceptor.FeignMDCInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Feign配置
 *
 * @author spy
 * @version 1.0 2019-06-22
 * @since 1.0
 */
@Slf4j
@Configuration
public class PanguFeignAutoConfigure {


    @Bean
    @ConditionalOnClass(FeignErrorDecoder.class)
    @ConditionalOnMissingBean(FeignErrorDecoder.class)
    @ConditionalOnProperty(prefix = "pangu", name = "feign.error-decoder.enable", havingValue = "true", matchIfMissing = true)
    public ErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }


    @Bean
    @ConditionalOnClass(FeignMDCInterceptor.class)
    @ConditionalOnMissingBean(FeignMDCInterceptor.class)
    @ConditionalOnProperty(prefix = "pangu", name = "feign.mdc-interceptor.enable", havingValue = "true", matchIfMissing = true)
    public RequestInterceptor feignMDCInterceptor() {

        log.debug("feign mdc interceptor bean init.");

        return new FeignMDCInterceptor();
    }

    /**
     * 日志等级
     *
     * @return
     */
    @Bean
    @Profile({"local", "dev", "test"})
    @ConditionalOnProperty(prefix = "pangu", name = "feign.log-level.enable", havingValue = "true", matchIfMissing = true)
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }


    @Bean("logLevel")
    @Profile({"pre", "prod"})
    @ConditionalOnProperty(prefix = "pangu", name = "feign.log-level.enable", havingValue = "true", matchIfMissing = true)
    public Logger.Level logLevel2() {
        return Logger.Level.HEADERS;
    }
}
