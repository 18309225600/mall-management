package com.lhf.mall.management.dto;


import com.lhf.mall.management.domain.GoodsImgEntity;
import lombok.Data;

import java.util.List;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/17
 **/
@Data
public class GoodsDto {
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
     * 国家
     */
    private String country;

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
     * 首图
     */
    private String headImg;
    /**
     * 主图
     */
    private List<GoodsImgEntity> mainImg;
    /**
     * 产品参数图片
     */
    private List<GoodsImgEntity> productParamImg;
    /**
     * 产品详情
     */
    private String detail;

}
