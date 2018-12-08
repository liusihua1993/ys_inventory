package com.ys.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 * 实体类对应的数据表为：  product_temp_material
 *
 * @author mlink
 * @date 2018-09-04 11:17:09
 */
@Getter
@Setter
@Alias("ProductTempMaterial")
public class ProductTempMaterial extends BaseEntity {
    /**
     * 主键
     */
    private String productTempMaterialId;

    /**
     * 产品模板id
     */
    private String productTempId;

    /**
     * 原料id
     */
    private String materialId;

    /**
     * 所需原料数量
     */
    private BigDecimal materialNum;

    /**
     * 排序
     */
    private String ptOrder;

    /**
     * vo
     */
    private String materialName;

}
