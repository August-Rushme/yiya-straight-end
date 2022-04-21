package com.yiya.dentalcity.wx.domain;

public class Doctor {
    private Integer id;

    private String name;

    private Integer age;

    private Integer workYears;

    private String gender;

    private String profession;

    private String title;

    private String clinicName;

    private Integer clinicId;

    private String avatar;

    private String gootAt;

    private String profile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorkYears() {
        return workYears;
    }

    public void setWorkYears(Integer workYears) {
        this.workYears = workYears;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGootAt() {
        return gootAt;
    }

    public void setGootAt(String gootAt) {
        this.gootAt = gootAt;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", workYears=").append(workYears);
        sb.append(", gender=").append(gender);
        sb.append(", profession=").append(profession);
        sb.append(", title=").append(title);
        sb.append(", clinicName=").append(clinicName);
        sb.append(", clinicId=").append(clinicId);
        sb.append(", avatar=").append(avatar);
        sb.append(", gootAt=").append(gootAt);
        sb.append(", profile=").append(profile);
        sb.append("]");
        return sb.toString();
    }
}