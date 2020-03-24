package com.miaosuan.pangu.core.cache;

import com.miaosuan.pangu.core.cache.lock.DistributedLock;
import com.miaosuan.pangu.core.cache.util.CacheKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模块名
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
@Slf4j
public class RedisDistributedLockTest {

    ApplicationContext ctx;

    DistributedLock distributedLock;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("classpath*:spring.xml");

        distributedLock = ctx.getBean(DistributedLock.class);
    }


    @Test
    public void lockTest() throws Exception {
        String key = CacheKeyUtil.get("b2b", "product", "1000");

        boolean result = distributedLock.lock(key);
        log.info("lock result={}", result);


        result = distributedLock.release(key);
        log.info("result result={}", result);
    }
}
