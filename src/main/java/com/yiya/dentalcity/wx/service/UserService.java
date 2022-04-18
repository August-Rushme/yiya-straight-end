package com.yiya.dentalcity.wx.service;

/**
 * @author 战神
 */
public interface UserService {
    /**
     * 注册用户
     * @param code
     * @param nickname
     * @param photo
     * @return
     */
    public int registerUser(String code,String nickname,String photo);
}
