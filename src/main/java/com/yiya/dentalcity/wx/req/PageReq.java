package com.yiya.dentalcity.wx.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel( value = "PageReq", description = "分页请求参数" )

public class PageReq {
    private int pageNum;

    private int pageSize;

    private String query;
}
