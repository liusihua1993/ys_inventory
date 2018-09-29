package com.ys.inventory.common.configurer.oauth2;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器 配置
 *
 * @author lsh
 * @version 201
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "*";

    /**
     * 资源安全配置
     *
     * @param resourceServerSecurityConfigurer 资源安全配置器
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) {
        resourceServerSecurityConfigurer
                .resourceId(RESOURCE_ID)
                .stateless(true);
    }


    /**
     * http安全配置
     *
     * @param httpSecurity http安全配置器
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .disable();
    }
}
