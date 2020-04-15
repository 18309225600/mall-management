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
@TableName("mall_goods")
public class GoodsEntity extends Model<GoodsEntity> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 产品品名
     */
    private String productName;

    /**
     * url后缀
     */
    private String urlSuffix;

    /**
     * facebook像素编号
     */
    private String facebookNum;

    /**
     * line像素编号
     */
    private String lineNum;

    /**
     * 模板ID
     */
    private Long templateId;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 域名
     */
    private String domainName;

    /**
     * 标题
     */
    private String title;

    /**
     * 特价
     */
    private String specialOffer;

    /**
     * 原价
     */
    private String originalOffer;

    /**
     * 货币符号
     */
    private String currencySymbol;

    /**
     * 销量
     */
    private Integer salesVolume;

    /**
     * 剩余件数
     */
    private Integer remainingNum;

    /**
     * 是否展示711店配 0否  1是
     */
    private Boolean showShopMatch;

    /**
     * 是否展示优惠码 0否 1是
     */
    private Boolean showDiscountCode;

    /**
     * 规格是否默认选择  0否  1是
     */
    private Boolean defaultSelectionSpecification;

    /**
     * 促销语
     */
    private String promotionWords;

    /**
     * 采购连接
     */
    private String purchaseLink;

    /**
     * 采购成本  单位：分
     */
    private Long purchaseCost;

    /**
     * 备注
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
