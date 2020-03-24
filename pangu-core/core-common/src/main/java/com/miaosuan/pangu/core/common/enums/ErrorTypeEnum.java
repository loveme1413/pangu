package com.miaosuan.pangu.core.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 错误类型
 *
 * @author spy
 * @version 1.0 2019/6/2
 * @since 1.0
 */
public enum ErrorTypeEnum {

    /**
     * 系统
     */
    SYSTEM("SYS", "系统"),
    /**
     * 应用
     */
    APPLICATION("Application", "应用"),
    /**
     * 业务
     */
    BIZ("BIZ", "业务");

    @Getter
    @Setter
    String code;
    @Getter
    @Setter
    String desc;

    ErrorTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
