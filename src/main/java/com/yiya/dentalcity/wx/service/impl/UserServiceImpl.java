package com.yiya.dentalcity.wx.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yiya.dentalcity.wx.dao.UserInfoMapper;
import com.yiya.dentalcity.wx.domain.UserInfo;
import com.yiya.dentalcity.wx.domain.UserInfoExample;
import com.yiya.dentalcity.wx.exception.BusinessException;
import com.yiya.dentalcity.wx.req.LoginByAccountForm;
import com.yiya.dentalcity.wx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    private String getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HashMap map = new HashMap();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String response = HttpUtil.post(url, map);
        JSONObject json = JSONUtil.parseObj(response);
        String openId = json.getStr("openid");
        if (openId == null || openId.length() == 0) {
            throw new RuntimeException("临时登陆凭证错误");
        }
        return openId;
    }

    /**
     * 注册
     *
     * @param code
     * @param nickName
     * @param photo
     * @return
     */
    @Override
    public int registerUser(String code, String nickName, String photo, String userName, String password) {
        // 注册用户
        String openId = getOpenId(code);
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenId(openId);
        userInfo.setNickname(nickName);
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setPhoto(photo);
        userInfo.setCreateTime(new Date());
        userInfo.setRole("[0]");
        userInfo.setStatus(1);
        userInfo.setRoot(true);

        userInfoMapper.insertSelective(userInfo);
        int id = userInfoMapper.searchIdByOpenId(openId);
        return id;
    }

    @Override
    public UserInfo getUser(LoginByAccountForm form) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUserNameEqualTo(form.getUserName());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if (userInfos.size() == 0) {
            throw new BusinessException("用户名不存在");
        }
        return userInfos.get(0);
    }

    @Override
    public UserInfo searchById(int userId) {
        UserInfo user = userInfoMapper.searchById(userId);
        return user;
    }

    @Override
    public UserInfo login(LoginByAccountForm form) {
        UserInfo userInfo = getUser(form);
        System.out.println(userInfo.getPassword().equals(form.getPassword()));
        if (userInfo.getPassword().equals(form.getPassword())) {
            return userInfo;
        } else {
            throw new BusinessException("帐户或密码错误");
        }
    }

    @Override
    public UserInfo loginByWx(String code) {
        String openId = getOpenId(code);
        Integer id = userInfoMapper.searchIdByOpenId(openId);
        if (id == null) {
            throw new BusinessException("帐户不存在");
        } else {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
            return userInfo;
        }
    }
}
