package com.ys.inventory.common.configurer.oauth2;

import com.google.common.collect.Sets;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * 自定义 身份认证服务器中的 ClientService
 * @author lsh
 * @version 2018/5/28.
 */
@Service
public class ClientService implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails baseClientDetails = new BaseClientDetails();
            baseClientDetails.setClientId("test_client");
        baseClientDetails.setAuthorizedGrantTypes(Sets.newHashSet(
                "password",
                "refresh_token"
        ));
        baseClientDetails.setScope(Sets.newHashSet("all"));
        // 10分钟
        baseClientDetails.setAccessTokenValiditySeconds(60 * 100);
        // 24小时
        baseClientDetails.setRefreshTokenValiditySeconds(60 * 60 * 24);
        return baseClientDetails;
    }
}
