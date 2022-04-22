package com.yiya.dentalcity.wx.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 战神
 */
@Data
@ApiModel(value = "AppointmentForm", description = "预约表单")
public class AppointmentForm extends PageReq {
    private Integer id;

    private String name;

    private String gender;

    private Date birthday;

    private String phone;

    private String project;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date appointmentTime;

    private String desc;

    private String clinic;

    private String doctor;

    private Integer userId;

    private String mark;

    private String status;

}
