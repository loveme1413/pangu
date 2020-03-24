package com.miaosuan.pangu.core.test;

import com.miaosuan.pangu.core.common.common.CoreConst;
import com.miaosuan.pangu.core.common.util.RandomUtil;
import com.miaosuan.pangu.core.common.util.StringUtil;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.TimeUnit;

/**
 * 测试基类
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
public abstract class AbstractCoreTest {

    protected static final Logger log = LoggerFactory.getLogger(AbstractCoreTest.class);


    @BeforeClass
    public static void start() {
        log.debug("=====================  start  =======================");
    }

    @AfterClass
    public static void end() {
        log.debug("=====================  end  =======================");
    }


    @Before
    public void init() {
        String requestId = MDC.get(CoreConst.MDC_REQUEST_ID);

        if (StringUtil.isEmpty(requestId)) {
            MDC.put(CoreConst.MDC_REQUEST_ID, RandomUtil.uuidShort());
        }
    }


    protected String getUUID() {

        return RandomUtil.uuid();
    }

    protected void sleepSecond(Integer timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }

    protected void sleepMinute(Integer timeout) {
        try {
            TimeUnit.MINUTES.sleep(timeout);
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }

}
