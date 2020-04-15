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
@TableName("mall_customer")
public class CustomerEntity extends Model<CustomerEntity> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户电话
     */
    private String phone;

    /**
     * 地区
     */
    private String region;

    /**
     * 地区ID
     */
    private Long regionId;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 留言
     */
    private String remark;

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
