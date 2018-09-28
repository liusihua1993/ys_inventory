package com.ys.inventory.common.configurer.oauth2.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lsh
 * @version 2018/6/11
 */
@Component
public class OauthExceptionTranslator extends DefaultWebResponseExceptionTranslator {

    private static final Map<String,String> messages;
    static{
        messages = new HashMap<>();
        messages.put("redirect_uri_mismatch","重定向地址不匹配");
        messages.put("invalid_request","请求不合法");
        messages.put("invalid_client","client_id或client_secret参数无效");
        messages.put("invalid_grant","账号、密码或公司代码不匹配");
        messages.put("unauthorized_client","客户端没有权限");
        messages.put("expired_token","token过期");
        messages.put("unsupported_grant_type","不支持的 GrantType");
        messages.put("unsupported_response_type","不支持的 ResponseType");
        messages.put("access_denied","用户或授权服务器拒绝授予数据访问权限");
        messages.put("temporarily_unavailable","服务暂时无法访问");

    }



    /**
     * @param e spring security内部异常
     * @return 处理后的异常信息
     * @throws Exception 通用异常
     */
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        ResponseEntity<OAuth2Exception> result = super.translate(e);
        OAuth2Exception resultBody = result.getBody();
        return ResponseEntity.status(HttpStatus.OK).body(createException(resultBody));
    }

    private CustomOauthException createException(OAuth2Exception resultBody){
        if(StringUtils.isEmpty(resultBody.getOAuth2ErrorCode())){
            return new CustomOauthException("10000","服务内部错误");
        }else{
            String msg = messages.get(resultBody.getOAuth2ErrorCode()) != null ?
                    messages.get(resultBody.getOAuth2ErrorCode()) : resultBody.getMessage();
            return new CustomOauthException("10001",msg);
        }
    }
}
