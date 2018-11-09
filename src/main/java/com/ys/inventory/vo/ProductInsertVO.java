package com.ys.inventory.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 实体类对应的数据表为：  product_temp
 *
 * @author mlink
 * @date 2018-09-04 10:47:47
 */
@ApiModel(value = "产品表")
@Getter
@Setter
@ToString
public class ProductInsertVO extends BaseVO{
    @ApiModelProperty(value = "主键")
    private String productId;

    @ApiModelProperty(value = "使用产品模板id")
    private String productTempId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品描述")
    private String productDescription;

    @ApiModelProperty(value = "产品数量")
    private String productNum;

}
