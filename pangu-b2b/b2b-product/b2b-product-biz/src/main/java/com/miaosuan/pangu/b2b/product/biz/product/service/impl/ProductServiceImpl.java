package com.miaosuan.pangu.b2b.product.biz.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.miaosuan.pangu.b2b.common.service.BaseBizService;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductQueryDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductSaveDTO;
import com.miaosuan.pangu.b2b.product.api.product.dto.ProductUpdateDTO;
import com.miaosuan.pangu.b2b.product.api.product.vo.ProductVO;
import com.miaosuan.pangu.b2b.product.biz.product.dao.ProductMapper;
import com.miaosuan.pangu.b2b.product.biz.product.entity.Product;
import com.miaosuan.pangu.b2b.product.biz.product.service.ProductService;
import com.miaosuan.pangu.core.common.model.PageInfoData;
import com.miaosuan.pangu.core.common.model.Result;
import com.miaosuan.pangu.core.orm.util.ExampleUtil;
import com.miaosuan.pangu.core.orm.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 产品服务实现类
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
@Service
public class ProductServiceImpl extends BaseBizService implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductVO save(ProductSaveDTO dto) {

        Product record = Product.builder()
                                .briefName(dto.getProductName())
                                .createTime(new Date())
                                .updateTime(new Date())
                                .build();
        int dbRow = productMapper.insertSelective(record);

        checkDB(dbRow);

        ProductVO productVO = ProductVO.builder()
                                       .productId(record.getProductId())
                                       .name(record.getBriefName())
                                       .build();
        return productVO;
    }

    @Override
    public boolean delete(Long productId) {

        Product record = Product.builder()
                                .productId(productId)
                                .deleted(true)
                                .updateTime(now())
                                .build();

        int dbRows = productMapper.updateByPrimaryKeySelective(record);
        checkDB(dbRows);

        return true;
    }

    @Override
    public boolean update(ProductUpdateDTO dto) {


        Product record = Product.builder()
                                .updateTime(now())
                                .build();

        BeanUtils.copyProperties(dto, record);

        int dbRows = productMapper.updateByPrimaryKeySelective(record);
        checkDB(dbRows);

        return true;
    }

    @Override
    public ProductVO queryDetail(Long productId) {

        Product product = productMapper.selectByPrimaryKey(productId);
        if (product != null) {

            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product, productVO);
            return productVO;
        }
        return null;
    }

    @Override
    public Result<PageInfoData<ProductVO>> queryList(ProductQueryDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getSize());

        Example example = new Example(Product.class);


        ExampleUtil.setLikeValue(example, "name", dto.getProductName());

        example.orderBy("productId").desc();


        List<Product> productList = productMapper.selectByExample(example);

        List<ProductVO> productVOList = productList.stream()
                                                   .map(item -> {
                                                       ProductVO vo = new ProductVO();
                                                       BeanUtils.copyProperties(item, vo);

                                                       return vo;
                                                   }).collect(Collectors.toList());

        return PageUtil.toPageInfoResult(productList, productVOList);
    }
}
