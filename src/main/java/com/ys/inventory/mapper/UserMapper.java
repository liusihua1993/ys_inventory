package com.ys.inventory.mapper;

import com.ys.inventory.entity.User;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */
public interface UserMapper {

    User getUserByPhoneForOauth(String username);
}
