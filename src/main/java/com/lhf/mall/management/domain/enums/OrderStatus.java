package com.lhf.mall.management.domain.enums;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/18
 **/
public enum OrderStatus {
    UN_PURCHASE(0,"未采购"),
    PURCHASED(1,"已经采购"),
    REPEATE_ORDER(2,"重复订单"),
    EXCEPTION_ORDER(3,"异常订单"),
    TEST_ORDER(4,"测试订单"),
    PRE_PURCHASE(5,"预采购"),
    SIGNED(6,"已签收"),
    RETURN(7,"退件"),
    UN_DELIVER(8,"未发货"),
    DELIVERED(9,"已发货"),
    TRANSPORT(10,"转运"),
    ERROR_ORDER(11,"错误订单"),
    DESTROY(12,"销毁")






    ;
    private int code;
    private String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderStatus codeOf(Integer status) {
        OrderStatus[] values = OrderStatus.values();
        for (OrderStatus orderStatus : values){
            if (orderStatus.getCode() == status){
                return orderStatus;
            }
        }
        return OrderStatus.UN_PURCHASE;
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
