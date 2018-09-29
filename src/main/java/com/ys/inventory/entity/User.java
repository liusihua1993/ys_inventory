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
    private String userId;
    private String userName;
    private String password;
    private String phone;
}
