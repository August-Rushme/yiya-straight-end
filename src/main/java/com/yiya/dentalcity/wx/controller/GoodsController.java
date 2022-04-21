package com.yiya.dentalcity.wx.controller;

import com.yiya.dentalcity.wx.domain.ClinicList;
import com.yiya.dentalcity.wx.domain.Doctor;
import com.yiya.dentalcity.wx.req.GetClinicForm;
import com.yiya.dentalcity.wx.req.PageReq;
import com.yiya.dentalcity.wx.resp.PageResp;
import com.yiya.dentalcity.wx.resp.R;
import com.yiya.dentalcity.wx.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 战神
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    /**
     * 获取诊所列表
     *
     * @return
     */
    @PostMapping("/getClinic")
    @ApiOperation("获取诊所列表")
    public R getGoods(GetClinicForm form) {
        PageResp<ClinicList> clinicList = goodsService.getClinicList(form);
        return R.ok().put("data", clinicList);
    }

    @PostMapping("/getClinicDetail/{id}")
    @ApiOperation("根据id获取诊所详情")
    public R getClinicDetail(@PathVariable("id") Integer id) {
        ClinicList clinicList = goodsService.getClinicById(id);
        //获取诊所的医生列表
        List<Doctor> clinicDoctorList = goodsService.getClinicDoctorList(id);
        clinicList.setDoctorList(clinicDoctorList);
        return R.ok().put("data", clinicList);
    }

    @PostMapping("/getClinicDoctor/{id}")
    @ApiOperation("通过诊所id获取诊所的医生列表")
    public R getClinicDoctor(@PathVariable("id") Integer id) {
        List<Doctor> clinicDoctorList = goodsService.getClinicDoctorList(id);
        return R.ok().put("data", clinicDoctorList);
    }

    @PostMapping("getAllDoctor")
    @ApiOperation("通过分页获取所有医生")
    public R getAllDoctor(@RequestBody PageReq req) {
        PageResp<Doctor> doctorList = goodsService.getDoctorList(req);
        return R.ok().put("data", doctorList);
    }
}
