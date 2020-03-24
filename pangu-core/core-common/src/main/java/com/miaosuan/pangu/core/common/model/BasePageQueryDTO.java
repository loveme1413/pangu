package com.miaosuan.pangu.core.common.model;

import lombok.Builder;
import lombok.Data;

/**
 * 分页请求参数
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Data
public class BasePageQueryDTO extends BaseRequestDTO {

    @Builder.Default
    protected Integer page = 1;

    @Builder.Default
    protected Integer size = 10;
}
