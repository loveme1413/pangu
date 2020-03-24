package com.miaosuan.pangu.b2b.product.api.product.client;

import com.miaosuan.pangu.b2b.product.api.product.client.fallback.ProductFeignClientFallback;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductQueryDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductSaveDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductUpdateDTO;
import com.miaosuan.pangu.b2b.product.api.product.vo.ProductVO;
import com.miaosuan.pangu.core.common.model.PageInfoData;
import com.miaosuan.pangu.core.common.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 产品服务client
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@FeignClient(value = "product-service", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    /**
     * 保存产品
     *
     * @param dto
     * @return
     */
    @PostMapping("/api/product/save")
    Result<ProductVO> save(@RequestBody ProductSaveDTO dto);

    /**
     * 删除商品
     * <p>这里不需指定name,feign获取值是没有判空</p>
     *
     * @param productId
     * @return
     */
    @GetMapping("/api/product/delete")
    Result<Boolean> delete(@RequestParam(name = "productId") Long productId);

    /**
     * 更新商品
     *
     * @param dto
     * @return
     */
    @PostMapping("/api/product/update")
    Result<Boolean> update(@RequestBody ProductUpdateDTO dto);

    /**
     * 获取产品详情
     *
     * @param productId
     * @return
     */
    @GetMapping("/api/product/detail")
    Result<ProductVO> getProduct(@RequestParam(name = "productId") Long productId);

    /**
     * 分页查询
     *
     * @param dto
     * @return
     */
    @PostMapping("/api/product/list")
    Result<PageInfoData<ProductVO>> queryList(@RequestBody ProductQueryDTO dto);

    /**
     * 保存时抛出异常
     *
     * @param dto
     * @return
     */
    @PostMapping("/api/product/saveException")
    Result<ProductVO> saveException(@RequestBody ProductSaveDTO dto);

    @GetMapping("/api/product/detail/not_exist")
    Result<ProductVO> queryDetail();
}
