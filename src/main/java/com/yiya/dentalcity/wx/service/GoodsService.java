package com.yiya.dentalcity.wx.service;

import com.yiya.dentalcity.wx.domain.ClinicList;
import com.yiya.dentalcity.wx.req.GetClinicForm;
import com.yiya.dentalcity.wx.resp.PageResp;

import java.util.List;

public interface GoodsService {

    /**
     * 获取所有的诊所列表
     * @return
     */
    PageResp<ClinicList> getClinicList(GetClinicForm form);
}
