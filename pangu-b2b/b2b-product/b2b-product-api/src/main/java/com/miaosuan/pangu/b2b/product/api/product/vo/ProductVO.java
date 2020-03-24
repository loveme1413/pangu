package com.miaosuan.pangu.b2b.product.api.product.vo;

import com.miaosuan.pangu.core.common.model.BaseResponseVO;
import lombok.*;

import java.util.List;

/**
 * product返回值类型
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
public class ProductVO extends BaseResponseVO {

    private Long productId;

    private String name;

    private String brandName;

    private List<String> productImgs;

    // maybe more...


}
