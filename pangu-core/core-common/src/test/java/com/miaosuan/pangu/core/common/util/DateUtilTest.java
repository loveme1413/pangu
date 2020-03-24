package com.miaosuan.pangu.core.common.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * 模块名
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
@Slf4j
public class DateUtilTest {

    @Test
    public void run16() throws Exception {

        log.info("{}", DateUtil.truncDate(new Date()));
    }
}
