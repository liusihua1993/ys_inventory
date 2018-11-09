package com.ys.inventory.vo;

import io.swagger.annotations.ApiModel;
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
public class BaseVO {
    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 删除标志	0：未删除，1：已删除
     */
    private Boolean deleteFlag;

}
