package com.yiya.dentalcity.wx.service.impl;

import com.yiya.dentalcity.wx.dao.AppointmentMapper;
import com.yiya.dentalcity.wx.domain.Appointment;
import com.yiya.dentalcity.wx.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public Appointment selectAppointment(Appointment appointment) {
        return null;
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
