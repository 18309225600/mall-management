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
 * @since 2020-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mall_order_process")
public class OrderProcessEntity extends Model<OrderProcessEntity> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 类型：0 添加备注 1更新状态 3填写物流信息
     */
    private Integer type;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 订单状态
     */
    private String orderStatus;

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
