package com.ys.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 实体类对应的数据表为：  product_temp
 * @author mlink
 * @date 2018-09-04 10:47:47
 */
@Getter
@Setter
@Alias("ProductTemp")
public class ProductTemp extends BaseEntity{
    /**
     *主键
     */
    private String productTempId;

    /**
     *产品模板名称
     */
    private String productTempName;

    /**
     *产品模板描述
     */
    private String productTempDescribe;

    /**
     * 模板对应的原料消耗信息
     */
    private List<ProductTempMaterial> productTempMaterialList;

}
