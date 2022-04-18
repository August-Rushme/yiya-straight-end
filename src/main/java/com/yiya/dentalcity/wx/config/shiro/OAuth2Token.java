package com.yiya.dentalcity.wx.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 战神
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
