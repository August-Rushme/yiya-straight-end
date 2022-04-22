package com.yiya.dentalcity.wx.service;

import com.yiya.dentalcity.wx.domain.Appointment;
import com.yiya.dentalcity.wx.req.AppointmentForm;
import com.yiya.dentalcity.wx.resp.PageResp;

public interface AppointmentService {

    /**
     * // 添加预约
     *
     * @param appointment
     * @return
     */
    public int addAppointment(Appointment appointment);

    /**
     * // 根据用户id查询预约信息
     *
     * @param form
     * @return
     */
    public PageResp<Appointment> getAppointmentByUserId(AppointmentForm form);

    // 更新预约
    public Appointment updateAppointment(Appointment appointment);

    // 删除预约
    public Appointment deleteAppointment(Appointment appointment);
}
