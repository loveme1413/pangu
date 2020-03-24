package com.miaosuan.pangu.core.cache.lock;

/**
 * 分布式锁
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
public interface DistributedLock {

    long TIMEOUT_MILLIS = 30000;

    int RETRY_TIMES = Integer.MAX_VALUE;

    long SLEEP_MILLIS = 500;


    /**
     * 获取锁
     *
     * @param key 唯一key
     * @return
     */
    boolean lock(String key);

    /**
     * 获取锁
     *
     * @param key        唯一key
     * @param retryTimes 尝试次数
     * @return
     */
    boolean lock(String key, int retryTimes);

    /**
     * 获取锁
     *
     * @param key         唯一key
     * @param retryTimes  尝试次数
     * @param sleepMillis 暂停时间
     * @return
     */
    boolean lock(String key, int retryTimes, long sleepMillis);

    /**
     * 获取锁
     *
     * @param key    唯一key
     * @param expire 超时时间
     * @return
     */
    boolean lock(String key, long expire);

    /**
     * 获取锁
     *
     * @param key        唯一key
     * @param expire     超时时间
     * @param retryTimes 尝试次数
     * @return
     */
    boolean lock(String key, long expire, int retryTimes);

    /**
     * 获取锁
     *
     * @param key         唯一key
     * @param expire      超时时间
     * @param retryTimes  重试次数
     * @param sleepMillis 暂停时间
     * @return
     */
    boolean lock(String key, long expire, int retryTimes, long sleepMillis);

    /**
     * 释放锁
     *
     * @param key 唯一key
     * @return
     */
    boolean release(String key);
}
