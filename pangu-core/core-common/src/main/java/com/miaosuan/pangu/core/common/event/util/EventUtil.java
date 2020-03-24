package com.miaosuan.pangu.core.common.event.util;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 本地事件类型
 *
 * @author spy
 * @version 1.0 2019/6/2
 * @since 1.0
 */
@Slf4j
public final class EventUtil {

    /**
     * 内部线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(
            10, 10,
            30, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(10000),
            new ThreadPoolExecutor.AbortPolicy());

    /**
     * 事件总线
     */
    public static final EventBus BUS = new AsyncEventBus(EXECUTOR_SERVICE);
}
