package com.yiya.dentalcity.wx.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yiya.dentalcity.wx.domain.Appointment;
import com.yiya.dentalcity.wx.req.AppointmentForm;
import com.yiya.dentalcity.wx.resp.PageResp;
import com.yiya.dentalcity.wx.resp.R;
import com.yiya.dentalcity.wx.service.AppointmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    public R addAppointment(@RequestBody Appointment appointment) {
        System.out.println(appointment);
        int i = appointmentService.addAppointment(appointment);
        if (i == 0) {
            return R.error("添加失败");
        }
        return R.ok("添加成功");

    }

    @PostMapping("getAppointment")
    @ApiOperation("获取预约")
    public R getAppointment(@RequestBody AppointmentForm form) {
        PageResp<Appointment> appointments = appointmentService.getAppointmentByUserId(form);
        return R.ok("获取成功").put("data", appointments);

    }

}

