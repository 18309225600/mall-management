package com.lhf.mall.management.domain.std;


/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/3/3
 **/
public class StdResponse<T> {
    public static final String CORRECT_STATUS = "ok";
    public static final String ERROR_STATUS = "error";
    public static final String CORRECT_CODE = "0";
    public static final String CORRECT_MSG = "操作成功";

    private String status;
    private String code;
    private String msg;
    private T data;

    public StdResponse() {
    }

    public StdResponse(String status, String code, String msg, T data) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> StdResponse newCorrectStdResponse(String msg, T data) {
        StdResponse stdResponse = new StdResponse();
        stdResponse.setStatus(StdResponse.CORRECT_STATUS);
        stdResponse.setCode(StdResponse.CORRECT_CODE);
        stdResponse.setMsg(msg);
        stdResponse.setData(data);
        return stdResponse;
    }

    public static <T> StdResponse newCorrectStdResponse(T data) {
        return StdResponse.newCorrectStdResponse(StdResponse.CORRECT_MSG, data);
    }

    public static StdResponse newCorrectStdResponse() {
        return StdResponse.newCorrectStdResponse("");
    }

    public static <T> StdResponse newCorrectPageStdResponse(Pagination<T> pagination) {
        return StdResponse.newCorrectStdResponse(pagination);
    }

    public static StdResponse newErrorStdResponse(String msg, String code) {
        StdResponse stdResponse = new StdResponse();
        stdResponse.setCode(code);
        stdResponse.setMsg(msg);
        stdResponse.setStatus(StdResponse.ERROR_STATUS);
        return stdResponse;
    }

    public static StdResponse newErrorStdResponse(StdErrorCodeEnum stdErrorCodeEnum){
        return newErrorStdResponse(stdErrorCodeEnum.getMsg(),stdErrorCodeEnum.getCode());
    }

    public static StdResponse newErrorStdResponse() {
        return StdResponse.newErrorStdResponse(StdErrorCodeEnum.MALL_GLOBAL_00001);
    }

    public static StdResponse newErrorStdResponse(StdException stdException){
        return StdResponse.newErrorStdResponse(stdException.getMsg(),stdException.getCode());
    }
}
