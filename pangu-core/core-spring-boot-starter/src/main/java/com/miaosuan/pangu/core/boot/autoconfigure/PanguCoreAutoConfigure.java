package com.miaosuan.pangu.core.boot.autoconfigure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.miaosuan.pangu.core.boot.autoconfigure.mvc.BaseWebMvcConfigure;
import com.miaosuan.pangu.core.cache.lock.impl.RedisDistributedLock;
import com.miaosuan.pangu.core.mvc.config.ApplicationInitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;

/**
 * 自动装配
 *
 * @author spy
 * @version 1.0 2019-06-19
 * @since 1.0
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(PanguProperties.class)
@Import({PanguFeignAutoConfigure.class, BaseWebMvcConfigure.class})
public class PanguCoreAutoConfigure {

    private ApplicationContext ctx;

    private PanguProperties panguProperties;

    PanguCoreAutoConfigure(ApplicationContext ctx, PanguProperties panguProperties) {
        this.ctx = ctx;
        this.panguProperties = panguProperties;
    }


    @Bean
    public ApplicationInitConfig applicationInitConfig() {
        return new ApplicationInitConfig();
    }

    @Bean
    @ConditionalOnClass({RedisTemplate.class, RedisDistributedLock.class})
    @ConditionalOnBean(RedisTemplate.class)
    @ConditionalOnProperty(prefix = "pangu", name = "redis.lock.enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean
    public RedisDistributedLock redisDistributedLock(RedisTemplate<String, Object> redisTemplate) {
        log.debug("redis distributed lock bean init.");

        return new RedisDistributedLock(redisTemplate);
    }


    @Bean
    @ConditionalOnClass(FastJsonHttpMessageConverter.class)
    @ConditionalOnProperty(prefix = "pangu", name = "fastjson.enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.IgnoreErrorGetter,
                SerializerFeature.WriteDateUseDateFormat
        );
        //
        fastConverter.setFastJsonConfig(fastJsonConfig);

        fastConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_JSON_UTF8));

        return fastConverter;
    }

    @Bean
    @ConditionalOnMissingBean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10000);
        executor.setThreadNamePrefix("pangu-TaskExecutor-");

        return executor;
    }

    @Bean
    @ConditionalOnMissingBean
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
        SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor();

        executor.setConcurrencyLimit(50);
        executor.setThreadNamePrefix("pangu-AsyncTaskExecutor-");

        return executor;
    }

}
