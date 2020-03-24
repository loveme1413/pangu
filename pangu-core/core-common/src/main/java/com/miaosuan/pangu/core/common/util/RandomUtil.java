package com.miaosuan.pangu.core.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * 随机数模块
 *
 * @author spy
 * @version 1.0 2019-06-19
 * @since 1.0
 */
@Slf4j
public final class RandomUtil {

    /**
     * uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }


    /**
     * 不带-的uuid
     *
     * @return
     */
    public static String uuidShort() {
        return uuid().replace("-", "");
    }
}
