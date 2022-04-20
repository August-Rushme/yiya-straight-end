package com.yiya.dentalcity.wx.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 战神
 */

@Data
@ApiModel(value = "LoginByAccountForm", description = "账号密码登录")
public class LoginByAccountForm {
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;

    private String code;
}

