package com.ys.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

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
    private Integer materialNum;

    /**
     * vo
     */
    private String materialName;

}
