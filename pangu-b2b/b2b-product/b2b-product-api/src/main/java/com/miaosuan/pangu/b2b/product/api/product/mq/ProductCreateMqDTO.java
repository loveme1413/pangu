package com.miaosuan.pangu.b2b.product.api.product.mq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 模块
 *
 * @author spy
 * @version 1.0 2019-07-14
 * @since 1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateMqDTO implements Serializable {

    private Long productId;

    private String productName;
}
