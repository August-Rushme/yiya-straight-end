package com.yiya.dentalcity.wx.controller;

import com.yiya.dentalcity.wx.domain.Appointment;
import com.yiya.dentalcity.wx.resp.R;
import com.yiya.dentalcity.wx.service.AppointmentService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 战神
 */
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Resource
    private AppointmentService appointmentService;

    /**
     * //添加预约
     *
     * @param appointment
     * @return
     */
    @PostMapping("/addAppointment")
    @ApiOperation("添加预约")
    public R addAppointment(Appointment appointment) {
        int i = appointmentService.addAppointment(appointment);
        if (i == 0) {
            return R.error("添加失败");
        }
        return R.ok("添加成功");

    }

}

