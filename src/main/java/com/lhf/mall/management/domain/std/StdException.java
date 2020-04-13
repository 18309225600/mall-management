package com.lhf.mall.management.domain.std;


/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/3/3
 **/
public class StdException extends RuntimeException {

    private String code;
    private String msg;

    public StdException() {
    }

    public StdException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public StdException(String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public StdException(StdErrorCodeEnum stdErrorCodeEnum){
        super(stdErrorCodeEnum.getMsg());
        this.code = stdErrorCodeEnum.getCode();
        this.msg = stdErrorCodeEnum.getMsg();
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
