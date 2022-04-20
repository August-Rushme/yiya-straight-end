package com.yiya.dentalcity.wx.dao;

import com.yiya.dentalcity.wx.domain.ClinicList;
import com.yiya.dentalcity.wx.domain.ClinicListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClinicListMapper {
    long countByExample(ClinicListExample example);

    int deleteByExample(ClinicListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClinicList record);

    int insertSelective(ClinicList record);

    List<ClinicList> selectByExample(ClinicListExample example);

    ClinicList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClinicList record, @Param("example") ClinicListExample example);

    int updateByExample(@Param("record") ClinicList record, @Param("example") ClinicListExample example);

    int updateByPrimaryKeySelective(ClinicList record);

    int updateByPrimaryKey(ClinicList record);
}