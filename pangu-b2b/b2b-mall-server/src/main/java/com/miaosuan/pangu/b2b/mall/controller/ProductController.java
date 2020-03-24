package com.miaosuan.pangu.b2b.mall.controller;

import com.miaosuan.pangu.b2b.product.api.product.client.ProductFeignClient;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductQueryDTO;
import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商城中product服务
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/mall/api/product")
public class ProductController {

    @Autowired
    ProductFeignClient productFeignClient;

    @GetMapping("list")
    public Result queryList(@RequestParam String productName) {

        log.info("远程调用");
        ProductQueryDTO dto = ProductQueryDTO.builder()
                                             .productName(productName)
                                             .build();

        return productFeignClient.queryList(dto);
    }
}
