package com.yiya.dentalcity.wx.service;

import com.yiya.dentalcity.wx.domain.UserInfo;
import com.yiya.dentalcity.wx.req.LoginByAccountForm;

/**
 * @author 战神
 */
public interface UserService {
    /**
     * 注册用户
     *
     * @param code
     * @param nickName
     * @param photo
     * @return
     */
    public int registerUser(String code, String nickName, String photo, String userName, String password);

    /**
     * 登录
     *
     * @param form
     * @return
     */
    public UserInfo login(LoginByAccountForm form);

    public UserInfo loginByWx(String code);

    public UserInfo getUser(LoginByAccountForm form);

    public UserInfo searchById(int userId);


}
