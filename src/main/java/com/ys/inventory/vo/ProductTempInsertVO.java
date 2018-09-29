package com.ys.inventory.vo;

import com.ys.inventory.entity.ProductTempMaterial;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 实体类对应的数据表为：  product_temp
 * @author mlink
 * @date 2018-09-04 10:47:47
 */
@ApiModel(value ="产品模板表")
@Getter
@Setter
@ToString
public class ProductTempInsertVO {
    @ApiModelProperty(value = "主键")
    private String productTempId;

    @ApiModelProperty(value = "产品模板名称")
    private String productTempName;

    @ApiModelProperty(value = "产品模板描述")
    private String productTempDescribe;

    @ApiModelProperty(value = "模板对应的原料消耗信息")
    private List<ProductTempMaterial> productTempMaterialList;

}
