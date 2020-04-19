package com.lhf.mall.management.domain.enums;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/19
 **/
public enum GoodsImgType {
    MAIN_IMG(0,"主图"),
    PARAM_IMG(1,"产品参数图")
    ;
    private int code;
    private String description;

    GoodsImgType(int code, String description) {
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
