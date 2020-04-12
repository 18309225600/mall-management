package com.lhf.mall.management.domain.std;

import lombok.Data;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/12
 **/
@Data
public class StdResponse<T> {
    public static final String CORRECT_MSG = "操作成功";
    public static final String CORRECT_CODE = "0";

    private String msg;
    private String code;
    private T data;

    public static<T> StdResponse<T> newCorrectResponse(T data){
        StdResponse<T> tStdResponse = new StdResponse<>();
        tStdResponse.setCode(CORRECT_CODE);
        tStdResponse.setMsg(CORRECT_MSG);
        tStdResponse.setData(data);
        return tStdResponse;
    }
}
