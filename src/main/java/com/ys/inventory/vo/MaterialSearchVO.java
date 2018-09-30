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
public class MaterialSearchVO extends BaseSearchVO {

    @ApiModelProperty(value = "materialId", hidden = true)
    private String materialId;

    @ApiModelProperty(value = "原料名称")
    private String materialName;
}
