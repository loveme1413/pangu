package com.miaosuan.pangu.b2b.product.api.product.dto;

import com.miaosuan.pangu.core.common.model.BasePageQueryDTO;
import lombok.*;

/**
 * product query dto
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductQueryDTO extends BasePageQueryDTO {

    private String productName;
}
