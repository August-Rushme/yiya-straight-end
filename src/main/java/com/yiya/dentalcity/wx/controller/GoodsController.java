package com.yiya.dentalcity.wx.controller;

import com.yiya.dentalcity.wx.domain.ClinicList;
import com.yiya.dentalcity.wx.req.GetClinicForm;
import com.yiya.dentalcity.wx.resp.PageResp;
import com.yiya.dentalcity.wx.resp.R;
import com.yiya.dentalcity.wx.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
    @PostMapping("/getClinic")
    @ApiOperation("获取诊所列表")
    public R getGoods(GetClinicForm form) {
        PageResp<ClinicList> clinicList = goodsService.getClinicList(form);
        return  R.ok().put("data",clinicList);
    }

}
