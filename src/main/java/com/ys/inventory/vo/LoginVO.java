package com.ys.inventory.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */
@ApiModel(value = "登录vo")
@Getter
@Setter
@ToString
public class LoginVO {
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;
}
