package com.lhf.mall.management.dto;

import lombok.Data;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/18
 **/
@Data
public class OrderDto {
    /**
     * 添加订单时录入信息
     */
    private Long goodsId;
    private Integer delivery;
    private String customerName;
    private String customerPhone;
    private String customerProvince;
    private String customerCity;
    private String customerAddress;
    private String customerEmail;
    private String customerRemark;

    /**
     * 后台备注
     */
    private String remark;
    /**
     * 后台更新状态
     */
    private Integer status;
    /**
     * 后台填写物流
     */
    private String deliveryCompany;
    private String deliveryNum;
}
