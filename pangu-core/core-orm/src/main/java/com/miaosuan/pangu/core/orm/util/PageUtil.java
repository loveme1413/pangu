package com.miaosuan.pangu.core.orm.util;

import com.github.pagehelper.PageInfo;
import com.miaosuan.pangu.core.common.model.PageInfoData;
import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 分页工具转换类
 *
 * @author spy
 * @version 1.0 2019/6/2
 * @since 1.0
 */
@Slf4j
public final class PageUtil {

    /**
     * 转换成带分页信息的result
     *
     * @param data 最终数据
     * @return
     */
    public static Result toPageInfoResult(List data) {
        Result result = Result.success();

        setPageInfo(data, result);

        return result;
    }

    /**
     * 转换成最终 Result
     *
     * @param oldData 含pageInfo关系的数据
     * @param newData 最终转换后的数据
     * @return
     */
    public static Result toPageInfoResult(List oldData, List newData) {
        PageInfo pageInfo = new PageInfo(oldData);

        return toPageInfoResult(newData, pageInfo.getTotal());
    }


    /**
     * 直接转换成分页列表
     *
     * @param data
     * @return
     */
    public static Result toSimplePageInfoResult(List data) {
        return toPageInfoResult(data, data == null ? 0 : data.size());
    }

    /**
     * 转换成带分页信息的result
     *
     * @param data  最终数据
     * @param total 记录数
     * @return
     */
    public static Result toPageInfoResult(List data, int total) {
        return toPageInfoResult(data, Long.valueOf(total));
    }

    /**
     * 转换成带分页信息的result
     *
     * @param data  最终数据
     * @param total 记录数
     * @return
     */
    public static Result toPageInfoResult(List data, Long total) {
        PageInfoData pageInfoData = new PageInfoData();

        pageInfoData.setRows(data);
        pageInfoData.setTotal(total);

        Result result = Result.success();
        result.setData(pageInfoData);
        return result;
    }

    /**
     * 直接将pageInfo转BaseResult
     *
     * @param pageInfo
     * @return
     */
    public static Result toPageInfoResult(PageInfo pageInfo) {

        return toPageInfoResult(pageInfo.getList(), pageInfo.getTotal());
    }


    /**
     * 设置分页信息
     *
     * @param data
     * @param result
     */
    public static void setPageInfo(List data, Result result) {
        PageInfo page = new PageInfo(data);

        PageInfoData pageInfoData = new PageInfoData();

        pageInfoData.setRows(data);
        pageInfoData.setTotal(page.getTotal());

        result.setData(pageInfoData);
    }


}