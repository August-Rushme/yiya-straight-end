package com.yiya.dentalcity.wx.dao;

import com.yiya.dentalcity.wx.domain.Doctor;
import com.yiya.dentalcity.wx.domain.DoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    long countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
}