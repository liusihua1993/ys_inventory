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
@ApiModel(value = "产品查询VO")
@Getter
@Setter
@ToString
public class ProductTempSearchVO extends BaseSearchVO {
    @ApiModelProperty(value = "主键")
    private String productTempId;

    @ApiModelProperty(value = "产品模板名称")
    private String productTempName;

}
