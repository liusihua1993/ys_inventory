package com.ys.inventory.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */
@ApiModel(value = "原料新增vo")
@Getter
@Setter
@ToString
public class MaterialInsertVO {
    @ApiModelProperty(value = "主键")
    private String materialId;

    @ApiModelProperty(value = "原料名称")
    private String materialName;

    @ApiModelProperty(value = "原料数量")
    private String materialNum;

    @ApiModelProperty(value = "原料描述")
    private String materialDescription;
}
