package com.ys.inventory.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author gp
 * @version 2018/07/12
 */
@ApiModel(value = "原料信息查询条件")
@Getter
@Setter
@ToString
public class MaterialSearchVO {

    @ApiModelProperty(value="materialId",hidden = true)
    private String materialId;

    @ApiModelProperty(value = "原料名称")
    private String materialName;

    @ApiModelProperty(value="分页参数，页码")
    Integer page = 1;

    @ApiModelProperty(value="分页参数，每页显示条数")
    Integer limit = 0;

    @ApiModelProperty(value="分页参数，排序")
    private String sort = "";

}
