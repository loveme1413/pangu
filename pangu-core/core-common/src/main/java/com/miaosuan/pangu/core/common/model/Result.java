package com.miaosuan.pangu.core.common.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.io.Serializable;

/**
 * 返回值封装类，对外接口必须使用
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Data
@Builder
@AllArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 操作结果
     */
    @JSONField(ordinal = 1000)
    @Builder.Default
    private Boolean success = true;

    /**
     * 请求id
     */
    @JSONField(ordinal = 1010)
    private String requestId;

    /**
     * 错误编码
     */
    @JSONField(ordinal = 1020)
    private String errorCode;

    /**
     * 错误信息中占位符变量
     */
    private transient Object[] errorParam;

    /**
     * 错误信息
     */
    @JSONField(ordinal = 1030)
    private String errorMessage;

    /**
     * 错误字段
     */
    @JSONField(ordinal = 1040)
    private String errorField;

    /**
     * 错误类别
     */
    @JSONField(ordinal = 1050)
    private String errorType;

    /**
     * 系统来源
     */
    @JSONField(ordinal = 1060)
    private String systemSource;

    /**
     * 默认返回结果
     */
    @JSONField(ordinal = 1100)
    private T data;


    public Result() {
        this(true, null);
    }

    public Result(boolean success) {
        this(success, null, null);
    }

    public Result(boolean success, String errorMessage) {
        this(success, errorMessage, null);
    }

    public Result(boolean success, String errorMessage, T data) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    /**
     * 直接返回true
     *
     * @return Result
     */
    public static Result success() {
        return new Result(true, null);
    }

    public static <T> Result success(T data) {
        return new Result(true, null, data);
    }

    public static Result fail() {
        return fail(null);
    }

    public static Result fail(String errorCode) {
        return fail(errorCode, null);
    }

    public static Result failMsg(String errorMessage) {
        return fail(null, errorMessage);
    }

    public static Result fail(String errorCode, String errorMessage) {
        Result result = new Result();

        result.setSuccess(false);
        result.setErrorCode(errorCode);
        result.setErrorMessage(errorMessage);
        return result;

    }

    /**
     * 格式化信息
     * <pre>
     *      result.setErrorMsg("{}拯救地球，{}!","xiaoming","yeah");
     *      //xiaoming拯救地球，yeah!
     *  </pre>
     *
     * @param format
     * @param argArray
     */
    public void setErrorMsg(String format, Object... argArray) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
        this.setErrorMessage(ft.getMessage());
    }
}
