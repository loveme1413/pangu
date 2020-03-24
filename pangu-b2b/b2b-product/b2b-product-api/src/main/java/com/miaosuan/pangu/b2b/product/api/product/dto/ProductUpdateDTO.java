package com.miaosuan.pangu.b2b.product.api.product.dto;

import com.miaosuan.pangu.core.common.model.BaseRequestDTO;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

/**
 * product 更新dto
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class ProductUpdateDTO extends BaseRequestDTO {

    @NotNull
    private Long productId;

    private String productName;

    private String creator;

    private String remark;


}
