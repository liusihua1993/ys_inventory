package com.ys.inventory.system.log.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel("日志查询条件")
@Setter
@Getter
@ToString
public class LogSearchVO implements Serializable {

    @ApiModelProperty(value = "功能模块")
    private String moduleName;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间起始")
    private String operationTimeStart;

    @ApiModelProperty(value = "操作时间结束")
    private String operationTimeEnd;

    @ApiModelProperty(value="分页参数，页码")
    Integer page = 1;

    @ApiModelProperty(value="分页参数，每页显示条数")
    Integer limit = 0;

    @ApiModelProperty(value="分页参数，排序")
    String sort = "";
}
