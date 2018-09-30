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
@ApiModel(value = "基础查询VO")
@Getter
@Setter
@ToString
public class BaseSearchVO {
    @ApiModelProperty(value = "分页参数，页码")
    Integer page = 1;

    @ApiModelProperty(value = "分页参数，每页显示条数")
    Integer limit = 0;

    @ApiModelProperty(value = "分页参数，排序")
    private String sort = "";

}
