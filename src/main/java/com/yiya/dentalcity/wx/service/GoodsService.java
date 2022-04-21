package com.yiya.dentalcity.wx.service;

import com.yiya.dentalcity.wx.domain.ClinicList;
import com.yiya.dentalcity.wx.domain.Doctor;
import com.yiya.dentalcity.wx.req.GetClinicForm;
import com.yiya.dentalcity.wx.req.PageReq;
import com.yiya.dentalcity.wx.resp.PageResp;

import java.util.List;

public interface GoodsService {

    /**
     * 获取所有的诊所列表
     *
     * @return
     */
    PageResp<ClinicList> getClinicList(GetClinicForm form);

    /**
     * 根据诊所id获取诊所信息
     *
     * @param id
     * @return
     */
    ClinicList getClinicById(Integer id);


    /**
     * 通过诊所id获取诊所的医生列表
     *
     * @param id
     * @return
     */
    List<Doctor> getClinicDoctorList(Integer id);


    /**
     * 获取所有的医生列表
     *
     * @param req
     * @return
     */
    PageResp<Doctor> getDoctorList(PageReq req);
}
