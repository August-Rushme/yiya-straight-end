package com.yiya.dentalcity.wx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yiya.dentalcity.wx.dao.ClinicListMapper;
import com.yiya.dentalcity.wx.dao.DoctorMapper;
import com.yiya.dentalcity.wx.domain.ClinicList;
import com.yiya.dentalcity.wx.domain.Doctor;
import com.yiya.dentalcity.wx.domain.DoctorExample;
import com.yiya.dentalcity.wx.req.GetClinicForm;
import com.yiya.dentalcity.wx.req.PageReq;
import com.yiya.dentalcity.wx.resp.PageResp;
import com.yiya.dentalcity.wx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 战神
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private ClinicListMapper clinicListMapper;
    @Resource
    private DoctorMapper doctorMapper;

    /**
     * 查询所有的医院
     *
     * @return
     */
    @Override
    public PageResp<ClinicList> getClinicList(GetClinicForm form) {
        Page<Object> page = PageHelper.startPage(form.getPageNum(), form.getPageSize());
        List<ClinicList> clinicLists = clinicListMapper.selectByExample(null);
        PageResp<ClinicList> pageResp = new PageResp<>();
        pageResp.setList(clinicLists);
        pageResp.setTotal(page.getTotal());
        return pageResp;
    }

    /**
     * 根据诊所id获取诊所信息
     *
     * @param id
     * @return
     */
    @Override
    public ClinicList getClinicById(Integer id) {
        return clinicListMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过诊所id获取诊所的医生列表
     *
     * @param id
     * @return
     */
    @Override
    public List<Doctor> getClinicDoctorList(Integer id) {
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria criteria = doctorExample.createCriteria().andClinicIdEqualTo(id);
        return doctorMapper.selectByExample(doctorExample);
    }

    /**
     * 通过分页获取所有的医生
     *
     * @return
     */
    @Override
    public PageResp<Doctor> getDoctorList(PageReq req) {
        Page<Object> page = PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<Doctor> doctors = doctorMapper.selectByExample(null);
        PageResp<Doctor> pageResp = new PageResp<>();
        pageResp.setList(doctors);
        pageResp.setTotal(page.getTotal());
        return pageResp;
    }


}
