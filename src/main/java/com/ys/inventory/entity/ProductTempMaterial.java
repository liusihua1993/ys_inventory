package com.ys.inventory.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 实体类对应的数据表为：  product_temp_material
 * @author mlink
 * @date 2018-09-04 11:17:09
 */
@ApiModel(value ="产品模板消耗原料表")
public class ProductTempMaterial {
    @ApiModelProperty(value = "主键")
    private String productTempMaterialId;

    @ApiModelProperty(value = "产品模板id")
    private String productTempId;

    @ApiModelProperty(value = "原料id")
    private String materialId;

    @ApiModelProperty(value = "所需原料数量")
    private Integer materialNum;

    /**
     * vo
     */
    private String materialName;

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getProductTempMaterialId() {
        return productTempMaterialId;
    }

    public void setProductTempMaterialId(String productTempMaterialId) {
        this.productTempMaterialId = productTempMaterialId;
    }

    public String getProductTempId() {
        return productTempId;
    }

    public void setProductTempId(String productTempId) {
        this.productTempId = productTempId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Integer getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(Integer materialNum) {
        this.materialNum = materialNum;
    }
}
