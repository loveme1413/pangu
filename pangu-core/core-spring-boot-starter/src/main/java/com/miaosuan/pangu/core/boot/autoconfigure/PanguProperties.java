package com.miaosuan.pangu.core.boot.autoconfigure;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 模块
 *
 * @author spy
 * @version 1.0 2019-06-22
 * @since 1.0
 */
@Data
@ConfigurationProperties("pangu")
public class PanguProperties {

    @NestedConfigurationProperty
    private Feign feign;

    @NestedConfigurationProperty
    private Web web;

    @NestedConfigurationProperty
    private Fastjson fastjson;

    @NestedConfigurationProperty
    private Redis redis;


    @Data
    public static class Fastjson {
        private Boolean enable;
    }


    @Data
    public static class Redis {
        private Lock lock;

        @Data
        public static class Lock {
            private Boolean enable;
        }

    }

    @Data
    public static class Feign {

        private ErrorDecoder errorDecoder;
        private MdcInterceptor mdcInterceptor;
        private LogLevel logLevel;

        @Data
        public static class ErrorDecoder {
            private Boolean enable;
        }

        @Data
        public static class MdcInterceptor {
            private Boolean enable;
        }

        @Data
        public static class LogLevel {
            private Boolean enable;
        }

    }

    @Data
    public static class Web {

        private MdcHandlerInterceptor mdcHandlerInterceptor;

        @Data
        public static class MdcHandlerInterceptor {

            private Boolean enable;

            private String[] pathList;
        }
    }

}
