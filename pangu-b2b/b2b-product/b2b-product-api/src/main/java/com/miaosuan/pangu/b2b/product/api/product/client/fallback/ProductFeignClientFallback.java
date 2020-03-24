package com.miaosuan.pangu.b2b.product.api.product.client.fallback;

import com.miaosuan.pangu.b2b.product.api.product.client.ProductFeignClient;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductQueryDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductSaveDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductUpdateDTO;
import com.miaosuan.pangu.b2b.product.api.product.vo.ProductVO;
import com.miaosuan.pangu.core.common.model.PageInfoData;
import com.miaosuan.pangu.core.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * product 降级服务
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Result<ProductVO> save(ProductSaveDTO dto) {
        return Result.failMsg("熔断错误");
    }

    @Override
    public Result<Boolean> delete(Long productId) {
        return Result.failMsg("熔断错误");
    }

    @Override
    public Result<Boolean> update(ProductUpdateDTO dto) {
        return Result.failMsg("熔断错误");
    }

    @Override
    public Result<ProductVO> getProduct(Long productId) {
        return Result.failMsg("熔断错误");
    }

    @Override
    public Result<PageInfoData<ProductVO>> queryList(ProductQueryDTO dto) {
        return Result.failMsg("熔断错误");
    }

    @Override
    public Result<ProductVO> saveException(ProductSaveDTO dto) {
        return Result.failMsg("熔断错误");
    }

    @Override
    public Result<ProductVO> queryDetail() {
        return Result.failMsg("熔断错误");
    }
}
