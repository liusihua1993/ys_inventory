package com.ys.inventory.system.log.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Setter
@Getter
@Alias("Log")
public class Log extends BaseRowModel implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 功能名称
     */
    @ExcelProperty(value = "功能名称", index = 0)
    private String moduleName;

    /**
     * 日志内容
     */
    @ExcelProperty(value = "日志内容", index = 1)
    private String content;

    /**
     * IP地址
     */
    @ExcelProperty(value = "IP地址", index = 2)
    private String ip;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 操作人
     */
    @ExcelProperty(value = "操作人", index = 3)
    private String operator;

    /**
     * 操作时间
     */
    @ExcelProperty(value = "操作时间", index = 4, format = "yyyy/MM/dd HH:mm:ss")
    private String operationTime;

    /**
     * 耗时时间
     */
    @ExcelProperty(value = "耗时时间(秒)", index = 5)
    private Long consumeTime;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 删除标志
     */
    private Boolean deleteFlag;

}
