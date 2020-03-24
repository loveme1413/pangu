package com.miaosuan.pangu.b2b.product.biz.product.controller;

import com.miaosuan.pangu.b2b.product.api.product.client.ProductFeignClient;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductQueryDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductSaveDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductUpdateDTO;
import com.miaosuan.pangu.b2b.product.api.product.vo.ProductVO;
import com.miaosuan.pangu.b2b.product.biz.product.common.ProductErrorConst;
import com.miaosuan.pangu.b2b.product.biz.product.service.ProductService;
import com.miaosuan.pangu.core.common.exception.ExceptionHandler;
import com.miaosuan.pangu.core.common.model.PageInfoData;
import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * product controller
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController implements ProductFeignClient {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    @Override
    public Result<ProductVO> save(@RequestBody ProductSaveDTO dto) {
        return Result.success(productService.save(dto));
    }

    @Override
    public Result<Boolean> delete(Long productId) {
        return Result.success(productService.delete(productId));
    }

    @Override
    public Result<Boolean> update(ProductUpdateDTO dto) {
        return Result.success(productService.update(dto));
    }

    @GetMapping("detail")
    @Override
    public Result<ProductVO> getProduct(Long productId) {
        return Result.success(productService.queryDetail(productId));
    }

    @PostMapping("/list")
    @Override
    public Result<PageInfoData<ProductVO>> queryList(@RequestBody ProductQueryDTO dto) {
        return productService.queryList(dto);
    }

    @PostMapping("/saveException")
    @Override
    public Result<ProductVO> saveException(ProductSaveDTO dto) {

//        ExceptionHandler.publish("PRODUCT_NOT_EXIST","产品不存在");
//        ExceptionHandler.publish("PRODUCT_NOT_EXIST");
        ExceptionHandler.publishMsg("产品不存在");

        return null;
    }

    @Override
    @GetMapping("/detail/not_exist")
    public Result<ProductVO> queryDetail() {
        ExceptionHandler.publish(ProductErrorConst.PRODUCT_NOT_EXIST);

        return null;
    }


}
