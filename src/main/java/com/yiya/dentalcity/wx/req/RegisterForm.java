package com.yiya.dentalcity.wx.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 战神
 */
@Data
@ApiModel(value = "RegisterForm", description = "注册表单")
public class RegisterForm {
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "微信临时授权不能为空")
    private String code;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @NotBlank(message = "头像不能为空")
    private String photo;


    private String password;
}
