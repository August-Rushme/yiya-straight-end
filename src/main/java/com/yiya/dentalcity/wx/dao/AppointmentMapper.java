package com.yiya.dentalcity.wx.dao;

import com.yiya.dentalcity.wx.domain.Appointment;
import com.yiya.dentalcity.wx.domain.AppointmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointmentMapper {
    long countByExample(AppointmentExample example);

    int deleteByExample(AppointmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    List<Appointment> selectByExample(AppointmentExample example);

    Appointment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    int updateByExample(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);
}