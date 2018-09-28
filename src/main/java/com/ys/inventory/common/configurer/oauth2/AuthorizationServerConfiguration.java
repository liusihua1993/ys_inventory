package com.ys.inventory.common.configurer.oauth2;

import com.ys.inventory.common.configurer.oauth2.exception.OauthExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 身份认证服务器 配置
 *
 * @author lsh
 * @version 2018/5/28.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    /**
     * 密码加密策略
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    public ClientService clientService;

    @Autowired
    public OauthExceptionTranslator oauthExceptionTranslator;


    @Bean
    public TokenStore getTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public TokenEnhancer tokenEnhancer(){
        return (accessToken, authentication) -> {
            if (accessToken instanceof DefaultOAuth2AccessToken){
                DefaultOAuth2AccessToken token= (DefaultOAuth2AccessToken) accessToken;
                Map<String, Object> additionalInformation = new LinkedHashMap<>();
                additionalInformation.put("expiration",accessToken.getExpiration().getTime());

                UserDetailsVO user = (UserDetailsVO) authentication.getPrincipal();
                additionalInformation.put("userId",user.getId());
                token.setAdditionalInformation(additionalInformation);
            }
            return accessToken;
        };
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenEnhancer(tokenEnhancer())
                .exceptionTranslator(oauthExceptionTranslator)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(getTokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientService);
    }
}
