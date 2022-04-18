package com.yiya.dentalcity.wx.config.shiro;

import org.springframework.stereotype.Component;

/**
 * @author 战神
 */
@Component
public class ThreadLocalToken {
    private ThreadLocal<String> local=new ThreadLocal<>();

    public void setToken(String token){
        local.set(token);
    }

    public String getToken(){
        return local.get();
    }

    public void clear(){
        local.remove();
    }
}
