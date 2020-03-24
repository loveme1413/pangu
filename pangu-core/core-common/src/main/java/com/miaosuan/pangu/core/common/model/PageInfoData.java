package com.miaosuan.pangu.core.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回信息
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfoData<T> implements Serializable {

    /**
     * 数据
     */
    private List<T> rows;

    /**
     * 总数
     */
    private Long total;

}

