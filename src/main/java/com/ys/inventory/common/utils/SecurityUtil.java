package com.ys.inventory.common.utils;

import com.ys.inventory.common.configurer.oauth2.UserDetailsVO;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * security信息
 * @author gp
 */
public class SecurityUtil {

    /**
     * 获取当前登录用户ID
     * 用户未登录时返回null
     *
     * @return 用户id
     */
    public static String getUserId() {
        return Optional.ofNullable(getUser()).map(UserDetailsVO::getId).orElse(null);
    }



    /**
     * 获取当前登录的用户
     * 用户未登录时返回null
     *
     * @return 当前登录的用户
     */
    public static UserDetailsVO getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!(principal instanceof UserDetailsVO)) {
            return null;
        }

        return (UserDetailsVO)principal;
    }

}
