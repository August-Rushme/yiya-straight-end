package com.yiya.dentalcity.wx.domain;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String openId;

    private String userName;

    private String password;

    private String nickname;

    private String photo;

    private String name;

    private String sex;

    private String tel;

    private String email;

    private Boolean root;

    private Integer status;

    private Date createTime;

    private String address;

    private Integer age;

    private Date updateTime;

    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", photo=").append(photo);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", root=").append(root);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", address=").append(address);
        sb.append(", age=").append(age);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", role=").append(role);
        sb.append("]");
        return sb.toString();
    }
}