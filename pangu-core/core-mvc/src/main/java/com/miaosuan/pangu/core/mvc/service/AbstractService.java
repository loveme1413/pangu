package com.miaosuan.pangu.core.mvc.service;

import com.miaosuan.pangu.core.common.common.CoreErrorConst;
import com.miaosuan.pangu.core.common.exception.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 基础抽象类
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
@Slf4j
public abstract class AbstractService {

    /**
     * 判断DB sql执行结果
     *
     * @param dbRows
     */
    protected void checkDB(int dbRows) {
        if (dbRows == 0) {
            ExceptionHandler.publish(CoreErrorConst.DB_ERR);
        }
    }

    /**
     * 当前时间
     *
     * @return
     */
    protected Date now() {
        return new Date();
    }
}
