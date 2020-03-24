package com.miaosuan.pangu.core.common.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 常量信息
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
public class CoreConst {

    /**
     * 操作人
     */
    public static String SYS_OPERATOR = "SYS_OPERATOR";
    /**
     * 创建人
     */
    public static String SYS_CREATOR = "SYS_CREATOR";
    /**
     * 修改人
     */
    public static String SYS_EDITOR = "SYS_EDITOR";

    /**
     * true
     */
    public static Boolean YES = Boolean.TRUE;
    /**
     * false
     */
    public static Boolean NO = Boolean.FALSE;

    /**
     * REQUEST_ID
     */
    public static String MDC_REQUEST_ID = "REQUEST_ID";

    /**
     * 请求中的参数requestId
     */
    public static String PARAM_REQUEST_ID = "requestId";


}
