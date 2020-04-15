package com.lhf.mall.management.domain.std;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/3/3
 **/
public enum StdErrorCodeEnum {

    MALL_GLOBAL_00001("100001","网络错误"),


    MALL_USER_00001("200001","用户未登陆"),
    MALL_USER_00002("200002","用户名或密码错误"),
    MALL_USER_00003("200003","用户状态错误"),
    MALL_USER_00004("200004","手机号已被占用"),
    MALL_USER_00005("200005","用户不存在"),


    MALL_GOODS_00001("300001","商品不存在"),


    ;




    private String code;
    private String msg;

    StdErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
