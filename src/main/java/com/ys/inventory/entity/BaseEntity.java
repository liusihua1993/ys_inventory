package com.ys.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */
@Getter
@Setter
@ToString
public class BaseEntity {
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
