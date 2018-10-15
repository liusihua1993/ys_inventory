package com.ys.inventory.service;

import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.entity.User;
import com.ys.inventory.mapper.UserMapper;
import com.ys.inventory.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/9
 * @Description
 */
@Service
@EnableTransactionManagement
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public User login(LoginVO vo) {
        User user = userMapper.getUserByPhoneForOauth(vo.getUsername());
        if (user != null) {
            if (vo.getPassword().equals(user.getPassword())) {
                user.setPassword(null);
                return user;
            } else {
                throw new BusinessException("密码不正确,请确认后登录");
            }
        } else {
            throw new BusinessException("用户不存在,请联系管理员");
        }
    }

}
