package com.lhf.mall.management.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mall_order")
public class OrderEntity extends Model<OrderEntity> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 国家
     */
    private String country;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户手机号
     */
    private String customerPhone;

    /**
     * 客户国家
     */
    private String customerCountry;

    private String customerProvince;
    private String customerCity;
    private String customerAddress;
    private String customerEmail;
    private String customerRemark;

    /**
     * 配送方式
     */
    private Integer delivery;

    /**
     * 金额
     */
    private String amount;

    /**
     * 货币符号
     */
    private String amoutCurrencySymbol;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 快递公司
     */
    private String deliveryCompany;

    /**
     * 快递单号
     */
    private String deliveryNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除时间
     */
    private LocalDateTime deletedTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
