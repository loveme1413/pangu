package com.miaosuan.pangu.core.orm.util;

import com.miaosuan.pangu.core.common.util.ListUtil;
import com.miaosuan.pangu.core.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * tk example util
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
@Slf4j
public final class ExampleUtil {
    /**
     * 赋值
     *
     * @param example
     * @param propertyName
     * @param value
     */
    public static void setValue(Example example, String propertyName, Object value) {
        if (value != null) {
            if (value instanceof String) {
                if (StringUtil.isNotEmpty(value)) {
                    example.and().andEqualTo(propertyName, value);
                }
            } else if (value instanceof List) {
                List dataList = (List) value;
                if (ListUtil.isNotEmpty(dataList)) {
                    example.and().andIn(propertyName, dataList);
                }
            } else {
                example.and().andEqualTo(propertyName, value);
            }
        }
    }

    /**
     * 模糊匹配
     *
     * @param example
     * @param propertyName
     * @param value
     */
    public static void setLikeValue(Example example, String propertyName, String value) {
        if (StringUtils.isNotEmpty(value)) {
            example.and().andLike(propertyName, "%" + value + "%");
        }
    }

    /**
     * 左匹配
     *
     * @param example
     * @param propertyName
     * @param value
     */
    public static void setLikeLeftValue(Example example, String propertyName, String value) {
        if (StringUtils.isNotEmpty(value)) {
            example.and().andLike(propertyName, "%" + value);
        }
    }

    /**
     * 右匹配
     *
     * @param example
     * @param propertyName
     * @param value
     */
    public static void setLikeRightValue(Example example, String propertyName, String value) {
        if (StringUtils.isNotEmpty(value)) {
            example.and().andLike(propertyName, value + "%");
        }
    }

    /**
     * 设置范围日期
     *
     * @param example
     * @param propertyName
     * @param beginDate
     * @param endDate
     */
    public static void setRangeDate(Example example, String propertyName, Date beginDate, Date endDate) {
        if (beginDate != null) {
            example.and().andGreaterThanOrEqualTo(propertyName, beginDate);
        }

        if (endDate != null) {
            example.and().andLessThanOrEqualTo(propertyName, endDate);
        }
    }
    /**
     * 设置多参数日期区间范围
     * eg:
     *  (propertyNameA>=beginDate   and propertyNameA<=endDate) || (propertyNameB>= beginDate     and propertyNameB <=endDate)
     * @param example
     * @param propertyNameA
     * @param propertyNameB
     * @param beginDate
     * @param endDate
     */
    public static void setRangeDateMore(Example example, String propertyNameA, String propertyNameB, Date beginDate, Date endDate) {
        if (StringUtil.isNotEmpty(beginDate) && StringUtil.isEmpty(endDate)) {
            ExampleUtil.setRangeDate(example, propertyNameA, beginDate, endDate);
        } else if (StringUtil.isEmpty(beginDate) && StringUtil.isNotEmpty(endDate)) {
            ExampleUtil.setRangeDate(example, propertyNameB, beginDate, endDate);
        } else if (StringUtil.isNotEmpty(beginDate) && StringUtil.isNotEmpty(endDate)) {
            example.and().andGreaterThanOrEqualTo(propertyNameA, beginDate).andLessThanOrEqualTo(propertyNameA,endDate)
             .orGreaterThanOrEqualTo(propertyNameB, beginDate).andLessThanOrEqualTo(propertyNameB,endDate);
        }
    }

}
