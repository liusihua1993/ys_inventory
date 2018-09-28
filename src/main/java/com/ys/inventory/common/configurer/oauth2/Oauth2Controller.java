package com.ys.inventory.common.configurer.oauth2;


import com.ys.inventory.common.core.Result;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsh
 */
@RestController
public class Oauth2Controller {
    @GetMapping("/oauth/user")
    public Result user(OAuth2Authentication user) {
        return Result.ok(user == null ? null:user.getPrincipal());
    }
}
