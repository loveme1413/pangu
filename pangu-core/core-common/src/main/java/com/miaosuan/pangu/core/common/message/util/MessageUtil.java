package com.miaosuan.pangu.core.common.message.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;

/**
 * 格式化文案信息
 *
 * @author spy
 * @version 1.0 2019/6/2
 * @since 1.0
 */
@Slf4j
public final class MessageUtil {

    /**
     * 格式化信息
     *
     * @param messagePattern
     * @param args
     * @return
     */
    public static String format(String messagePattern, Object... args) {
        return MessageFormatter.arrayFormat(messagePattern, args).getMessage();
    }

}