package com.lhf.mall.management.domain.enums;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/14
 **/
public enum UserStatus {
    NOMAL(0,"正常"),
    DISABLE(1,"禁用"),


    ;

    private int code;
    private String description;

    UserStatus(int code, String description) {
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
