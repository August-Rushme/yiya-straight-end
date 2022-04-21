package com.yiya.dentalcity.wx.domain;

import java.util.List;

public class ClinicList {
    private Integer id;

    private String name;

    private String address;

    private String detailedAddress;

    private String label;

    private String scope;

    private String img;

    private String rate;

    private String img2;

    private String banner;

    private List<Doctor> doctorList;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public String toString() {
        return "ClinicList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", label='" + label + '\'' +
                ", scope='" + scope + '\'' +
                ", img='" + img + '\'' +
                ", rate='" + rate + '\'' +
                ", img2='" + img2 + '\'' +
                ", banner='" + banner + '\'' +
                ", doctorList=" + doctorList +
                '}';
    }
}