package com.ys.inventory.system.log.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author gp
 * @version 2018/06/20
 */
@ApiModel("日志插入参数")
@Setter
@Getter
@ToString
public class LogInsertVO implements Serializable {

    @ApiModelProperty(value = "ID", hidden = true)
    private String id;

    @ApiModelProperty(value = "功能名称")
    private String moduleName;

    @ApiModelProperty(value = "日志内容")
    private String content;

    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private String operationTime;

    @ApiModelProperty(value = "耗时时间")
    private Float consumeTime;

    @ApiModelProperty(value = "创建用户")
    private String createUser;
}
