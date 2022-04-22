package com.yiya.dentalcity.wx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yiya.dentalcity.wx.dao.AppointmentMapper;
import com.yiya.dentalcity.wx.domain.Appointment;
import com.yiya.dentalcity.wx.domain.AppointmentExample;
import com.yiya.dentalcity.wx.req.AppointmentForm;
import com.yiya.dentalcity.wx.resp.PageResp;
import com.yiya.dentalcity.wx.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 战神
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;

    @Override
    public int addAppointment(Appointment appointment) {
        return appointmentMapper.insertSelective(appointment);
    }

    @Override
    public PageResp<Appointment> getAppointmentByUserId(AppointmentForm form) {
        AppointmentExample appointmentExample = new AppointmentExample();
        appointmentExample.createCriteria().andUserIdEqualTo(form.getUserId());
        Page<Object> page = PageHelper.startPage(form.getPageNum(), form.getPageSize());
        List<Appointment> appointments = appointmentMapper.selectByExample(appointmentExample);
        PageResp<Appointment> pageResp = new PageResp<>();
        pageResp.setList(appointments);
        pageResp.setTotal(page.getTotal());
        return pageResp;
    }


    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment deleteAppointment(Appointment appointment) {
        return null;
    }
}
