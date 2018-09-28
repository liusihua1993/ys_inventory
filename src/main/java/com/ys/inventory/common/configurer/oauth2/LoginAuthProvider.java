package com.ys.inventory.common.configurer.oauth2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * 自定义 AuthProvider
 *
 * @author lsh
 * @date 2018-09-03 16:20:00
 */
@Component
public class LoginAuthProvider implements AuthenticationProvider {
    private static final Logger logger = Logger.getLogger(LoginAuthProvider.class);
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("authenticate");

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        LinkedHashMap client_id1 = (LinkedHashMap) authentication.getDetails();
        String client_id = (String) client_id1.get("client_id");

        UserDetailsVO userEntity = (UserDetailsVO) userDetailsService.loadUserByUsername(username);
        if (null == userEntity) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        if (!userEntity.isEnabled()) {
            throw new DisabledException("您已被封号");
        }

        if (!password.equals(userEntity.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }

        Collection<? extends GrantedAuthority> authorities = userEntity.getAuthorities();
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userEntity, password, authorities);
        return user;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }

}
