package com.miaosuan.pangu.b2b.mall.service;

import com.miaosuan.pangu.b2b.mall.AbstractSpringTest;
import com.miaosuan.pangu.b2b.product.api.product.client.ProductFeignClient;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductSaveDTO;
import com.miaosuan.pangu.b2b.product.api.product.vo.ProductVO;
import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 模块名
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
public class MallServiceTest extends AbstractSpringTest {

    @Autowired
    ProductFeignClient productFeignClient;

    @Test
    public void saveProductByRemote() throws Exception {

        ProductSaveDTO dto = ProductSaveDTO.builder()
                                           .productName("奶茶" + UUID.randomUUID().toString())
                                           .build();
        Result<ProductVO> result = productFeignClient.save(dto);

        log.info("result={}", result);

    }

    @Test
    public void saveProductByException() throws Exception {
        ProductSaveDTO dto = ProductSaveDTO.builder()
                                           .productName("奶茶" + UUID.randomUUID().toString())
                                           .build();
        Result<ProductVO> result = productFeignClient.saveException(dto);

        log.info("result={}", result);
    }


}
