package com.yiya.dentalcity.wx.controller;

import com.yiya.dentalcity.wx.config.shiro.JwtUtil;
import com.yiya.dentalcity.wx.domain.UserInfo;
import com.yiya.dentalcity.wx.req.LoginByAccountForm;
import com.yiya.dentalcity.wx.req.LoginByWXForm;
import com.yiya.dentalcity.wx.req.RegisterForm;
import com.yiya.dentalcity.wx.resp.R;
import com.yiya.dentalcity.wx.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * @author 战神
 */
@RestController
@RequestMapping("/user")
@Api("用户模块Web接口")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${yiya.jwt.cache-expire}")
    private int cacheExpire;

    @PostMapping("/register")
    @ApiOperation("注册用户")
    public R register(@Valid @RequestBody RegisterForm form){
        System.out.println(form);
        int id=userService.registerUser(form.getCode(),form.getNickName(),form.getPhoto(),form.getUserName(),form.getPassword());
        String token=jwtUtil.createToken(id);
        // 将token存入redis
        saveCacheToken(token,id);
        return R.ok("用户注册成功").put("token",token);
    }
    @PostMapping("/loginByWx")
    @ApiOperation("用户微信登录")
    public R loginByWx(@Valid @RequestBody LoginByWXForm form){
        UserInfo user = userService.loginByWx(form.getCode());
        String token=jwtUtil.createToken(user.getId());
        saveCacheToken(token,user.getId());
        return R.ok("登陆成功").put("token",token).put("user",user);
    }
    @PostMapping("/loginByAccount")
    @ApiOperation("用户账号登录")
    public R loginByAccount(@Valid @RequestBody LoginByAccountForm form){
        UserInfo user = userService.login(form);
        String token=jwtUtil.createToken(user.getId());
        saveCacheToken(token,user.getId());
        return R.ok("登陆成功").put("token",token).put("user",user);
    }

    private void saveCacheToken(String token,int userId){
        redisTemplate.opsForValue().set(token,userId+"",cacheExpire, TimeUnit.DAYS);
    }

}
