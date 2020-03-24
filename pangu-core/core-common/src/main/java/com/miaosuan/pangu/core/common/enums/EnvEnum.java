package com.miaosuan.pangu.core.common.enums;

/**
 * 开发环境变量
 *
 * @author spy
 * @version 1.0 2019-06-21
 * @since 1.0
 */
public enum EnvEnum {

    LOCAL("local"),
    DEV("dev"),
    TEST("test"),
    PRE("pre"),
    PROD("prod");


    private String key;

    EnvEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
