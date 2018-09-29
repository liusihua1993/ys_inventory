package com.ys.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */
@Getter
@Setter
@Alias("User")
public class User {
    /**
     * 主键
     */
    private String userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;
}
