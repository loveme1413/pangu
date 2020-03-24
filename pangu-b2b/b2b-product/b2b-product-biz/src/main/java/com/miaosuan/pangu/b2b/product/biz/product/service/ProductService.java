package com.miaosuan.pangu.b2b.product.biz.product.service;

import com.miaosuan.pangu.b2b.product.api.product.dto.ProductQueryDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductSaveDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductUpdateDTO;
import com.miaosuan.pangu.b2b.product.api.product.vo.ProductVO;
import com.miaosuan.pangu.core.common.model.PageInfoData;
import com.miaosuan.pangu.core.common.model.Result;

/**
 * product 服务接口
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
public interface ProductService {

    /**
     * 保存商品
     *
     * @param dto
     * @return
     */
    ProductVO save(ProductSaveDTO dto);

    /**
     * 删除产品
     *
     * @param productId
     * @return
     */
    boolean delete(Long productId);

    /**
     * 更新产品
     *
     * @param dto
     * @return
     */
    boolean update(ProductUpdateDTO dto);

    /**
     * 查询商品
     *
     * @param productId
     * @return
     */
    ProductVO queryDetail(Long productId);

    /**
     * 查询商品列表
     *
     * @param dto
     * @return
     */
    Result<PageInfoData<ProductVO>> queryList(ProductQueryDTO dto);
}
