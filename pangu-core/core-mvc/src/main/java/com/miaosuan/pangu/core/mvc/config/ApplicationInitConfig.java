package com.miaosuan.pangu.core.mvc.config;

import com.miaosuan.pangu.core.common.intf.ApplicationInitInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 初始化配置
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
@Slf4j
public class ApplicationInitConfig {

    @Autowired
    private ApplicationContext ctx;

    @PostConstruct
    public void init() {
        Map<String, ApplicationInitInterface> beanMap = ctx.getBeansOfType(ApplicationInitInterface.class);

        if (beanMap == null || beanMap.isEmpty()) {
            return;
        }

        beanMap.forEach((beanName, bean) -> {
            log.info("init bean[{}] begin.", beanName);
            try {
                bean.init();
            } catch (Exception e) {
                log.error("fail to init bean init method", e);
            } finally {
                log.info("init bean[{}] end.", beanName);
            }
        });


    }

}
