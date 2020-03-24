package com.miaosuan.pangu.b2b.product.biz.product.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品实体
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "`product`")
public class Product {
    @Id
    @Column(name = "`product_id`")
    @GeneratedValue(generator = "JDBC")
    private Long productId;

    /**
     * 属性模版ID
     */
    @Column(name = "`attr_template_id`")
    private Long attrTemplateId;

    /**
     * 属性模板名称
     */
    @Column(name = "`attr_template_name`")
    private String attrTemplateName;

    /**
     * 品牌id
     */
    @Column(name = "`brand_id`")
    private Long brandId;

    /**
     * 品牌名称
     */
    @Column(name = "`brand_name`")
    private String brandName;

    /**
     * 品牌体系id
     */
    @Column(name = "`price_group_id`")
    private Long priceGroupId;

    /**
     * 品牌体系名称
     */
    @Column(name = "`price_group_name`")
    private String priceGroupName;

    /**
     * 简称
     */
    @Column(name = "`brief_name`")
    private String briefName;

    /**
     * 所属类目(多级类目id用逗号隔开)
     */
    @Column(name = "`catalog_id_path`")
    private String catalogIdPath;

    /**
     * 所属类目(多级类目id用逗号隔开)
     */
    @Column(name = "`catalog_name_path`")
    private String catalogNamePath;

    /**
     * 所属类别(多级类别id用逗号隔开)
     */
    @Column(name = "`category_id`")
    private Long categoryId;

    /**
     * 所属类别(多级类别name用逗号隔开)
     */
    @Column(name = "`category_id_path`")
    private String categoryIdPath;

    /**
     * 类目名称
     */
    @Column(name = "`category_name`")
    private String categoryName;

    /**
     * 所属类别(多级类别name用逗号隔开)
     */
    @Column(name = "`category_name_path`")
    private String categoryNamePath;

    /**
     * 被引用次数
     */
    @Column(name = "`be_referenced_times`")
    private Integer beReferencedTimes;

    /**
     * 封面图
     */
    @Column(name = "`cover_image`")
    private String coverImage;

    /**
     * 关键字, 请用;分割 (英文) [保留字段]
     */
    @Column(name = "`keywords`")
    private String keywords;

    /**
     * 是否清真
     */
    @Column(name = "`is_muslim`")
    private Boolean isMuslim;

    /**
     * 保质期
     */
    @Column(name = "`expiration_date`")
    private String expirationDate;

    /**
     * 商品名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 下次到货时间
     */
    @Column(name = "`next_delivery_time`")
    private Date nextDeliveryTime;

    /**
     * 价格浮动标识
     */
    @Column(name = "`price_float_data`")
    private String priceFloatData;

    /**
     * 商品型号. [保留字段]
     */
    @Column(name = "`product_model`")
    private String productModel;

    /**
     * 商品编码,一般用来做识别号. [保留字段]
     */
    @Column(name = "`product_no`")
    private String productNo;

    /**
     * 商品状态:UN_SUBMIT-未提交,WAIT_SUBMIT-待提交,WAIT_AUDITING-待审核,NOT_PASS-未通过,UP-已上架, DOWN-已下架
     */
    @Column(name = "`product_status`")
    private String productStatus;

    /**
     * 商品类型 [保留字段]
     */
    @Column(name = "`product_type`")
    private String productType;

    /**
     * 标签, ID
     */
    @Column(name = "`tag_ids`")
    private String tagIds;

    /**
     * 标签, 冗余业务字段
     */
    @Column(name = "`tags`")
    private String tags;

    /**
     * 交易者ID
     */
    @Column(name = "`trader_id`")
    private Long traderId;

    @Column(name = "`display_order`")
    private Integer displayOrder;

    /**
     * 是否启用
     */
    @Column(name = "`enabled`")
    private Boolean enabled;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 是否删除
     */
    @Column(name = "`deleted`")
    private Boolean deleted;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`create_user_id`")
    private Long createUserId;

    @Column(name = "`create_user_name`")
    private String createUserName;

    @Column(name = "`update_time`")
    private Date updateTime;

    @Column(name = "`update_user_id`")
    private Long updateUserId;

    @Column(name = "`update_user_name`")
    private String updateUserName;

    @Column(name = "`version`")
    private Integer version;

    /**
     * 手工费
     */
    @Column(name = "`process_fee`")
    private BigDecimal processFee;

    /**
     * 货主ID
     */
    @Column(name = "`cargo_owner_id`")
    private Long cargoOwnerId;

    /**
     * 属性值(json)
     */
    @Column(name = "`attr_data`")
    private String attrData;

    /**
     * 商品SKU(json)
     */
    @Column(name = "`spec_data`")
    private String specData;

    /**
     * 包装单位(json)
     */
    @Column(name = "`packaging_unit_data`")
    private String packagingUnitData;
}