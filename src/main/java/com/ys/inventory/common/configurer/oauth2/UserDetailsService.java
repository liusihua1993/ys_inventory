package com.ys.inventory.common.configurer.oauth2;

import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.entity.User;
import com.ys.inventory.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义 UserDetailsService
 *
 * @author lsh
 * @version 2018/6/13
 */
@Slf4j
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByPhoneForOauth(username);
        if (user == null) {
            throw new BusinessException("用户不存在，请确认后在登录");
        }
        UserDetailsVO userDetailsVO = new UserDetailsVO();
        userDetailsVO.setUsername(user.getUserName());
        userDetailsVO.setId(user.getUserId());
        userDetailsVO.setPassword(user.getPassword());
        return userDetailsVO;
    }

}
