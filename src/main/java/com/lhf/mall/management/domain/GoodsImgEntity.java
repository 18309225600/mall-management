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
 * 商品其他图片
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mall_goods_img")
public class GoodsImgEntity extends Model<GoodsImgEntity> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 图片类型：0:产品主图  1:产品参数   2:产品详情
     */
    private Integer type;

    /**
     * 图片地址
     */
    private String url;

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
