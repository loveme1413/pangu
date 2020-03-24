package com.miaosuan.pangu.b2b.product.server.service;

import com.miaosuan.pangu.b2b.product.biz.product.dao.ProductMapper;
import com.miaosuan.pangu.b2b.product.biz.product.entity.Product;
import com.miaosuan.pangu.b2b.product.server.AbstractSpringBootTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 模块名
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
public class ProductServiceTest extends AbstractSpringBootTest {

    @Autowired
    private ProductMapper productMapper;


    @Test
    public void saveProductTest() throws Exception {
        Product record = Product.builder()
                                .briefName("奶茶")
                                .deleted(false)
                                .createTime(new Date())
                                .updateTime(new Date())

                                .build();

        productMapper.insertSelective(record);
        log.info("record={}", record);
    }

}
