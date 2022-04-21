package com.yiya.dentalcity.wx.service;

import com.yiya.dentalcity.wx.domain.Appointment;

public interface AppointmentService {

    /**
     * // 添加预约
     *
     * @param appointment
     * @return
     */
    public int addAppointment(Appointment appointment);

    // 查询预约
    public Appointment selectAppointment(Appointment appointment);

    // 更新预约
    public Appointment updateAppointment(Appointment appointment);

    // 删除预约
    public Appointment deleteAppointment(Appointment appointment);
}
