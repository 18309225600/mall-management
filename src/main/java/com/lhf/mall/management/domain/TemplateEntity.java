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
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mall_template")
public class TemplateEntity extends Model<TemplateEntity> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 地区
     */
    private String region;

    /**
     * 地区编码
     */
    private String regionCode;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 货币符号
     */
    private String currencySymbol;

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
