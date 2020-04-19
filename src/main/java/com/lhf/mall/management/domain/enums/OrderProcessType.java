package com.lhf.mall.management.domain.enums;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/18
 **/
public enum OrderProcessType {
    ADD_REMARK(0,"添加备注"),
    UPDATE_STATUS(1,"更新订单状态"),
    WRITE_DELIVERY_INFO(2,"填写物流信息")


    ;
    private int code;
    private String description;

    OrderProcessType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
