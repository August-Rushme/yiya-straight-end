package com.yiya.dentalcity.wx.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yiya.dentalcity.wx.dao.UserInfoMapper;
import com.yiya.dentalcity.wx.domain.UserInfo;
import com.yiya.dentalcity.wx.exception.BusinessException;
import com.yiya.dentalcity.wx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * @author 战神
 */
@Service
@Slf4j
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Value("${wx.app-id}")
    private String appId;

    @Value("${wx.app-secret}")
    private String appSecret;

    @Resource
    UserInfoMapper userInfoMapper;

    private String getOpenId(String code){
        String url="https://api.weixin.qq.com/sns/jscode2session";
        HashMap map=new HashMap();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String response= HttpUtil.post(url,map);
        JSONObject json= JSONUtil.parseObj(response);
        String openId=json.getStr("openid");
        if(openId==null||openId.length()==0){
            throw new RuntimeException("临时登陆凭证错误");
        }
        return openId;
    }

    /**
     * 注册
     * @param code
     * @param nickName
     * @param photo
     * @return
     */
    @Override
    public int registerUser( String code, String nickName, String photo) {
        // 注册用户
        String openId = getOpenId(code);
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenId(openId);
        userInfo.setNickname(nickName);
        userInfo.setPhoto(photo);
        userInfo.setCreateTime(new Date());
        userInfo.setRole("[0]");
        userInfo.setStatus(1);
        userInfo.setRoot(true);
        userInfoMapper.insertSelective(userInfo);
        int id=userInfoMapper.searchIdByOpenId(openId);
        return id;
    }
}
