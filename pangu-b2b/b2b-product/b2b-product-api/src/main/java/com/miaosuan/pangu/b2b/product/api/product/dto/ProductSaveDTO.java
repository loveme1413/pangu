package com.miaosuan.pangu.b2b.product.api.product.dto;

import com.miaosuan.pangu.core.common.model.BaseRequestDTO;
import lombok.*;

import java.util.List;

/**
 * 产品保存dto
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductSaveDTO extends BaseRequestDTO {

    private String productName;

    private String creator;

    private String remark;


    private List<String> productImgs;

}
