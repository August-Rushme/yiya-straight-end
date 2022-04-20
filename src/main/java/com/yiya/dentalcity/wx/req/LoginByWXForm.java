package com.yiya.dentalcity.wx.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 战神
 */

@ApiModel("微信登录")
@Data
public class LoginByWXForm {
    @NotBlank(message = "临时授权码不能为空")
    private String code;
}
