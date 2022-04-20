package com.yiya.dentalcity.wx.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author 战神
 */
@Data
@ApiModel(value = "GetClinicForm", description = "查询诊所表单")
public class GetClinicForm extends PageReq {
    private Integer clinic_id;
}
