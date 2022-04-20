package com.yiya.dentalcity.wx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yiya.dentalcity.wx.dao.ClinicListMapper;
import com.yiya.dentalcity.wx.domain.ClinicList;
import com.yiya.dentalcity.wx.req.GetClinicForm;
import com.yiya.dentalcity.wx.resp.PageResp;
import com.yiya.dentalcity.wx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 战神
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private ClinicListMapper clinicListMapper;

    /**
     * 查询所有的医院
     * @return
     */
    @Override
    public PageResp<ClinicList> getClinicList(GetClinicForm form) {
        Page<Object> page = PageHelper.startPage(form.getPageNum(), form.getPageSize());
        List<ClinicList> clinicLists = clinicListMapper.selectByExample(null);
        PageResp<ClinicList> pageResp = new PageResp<>();
        pageResp.setList(clinicLists);
        pageResp.setTotal(page.getPages());
        return pageResp;
    }
}
