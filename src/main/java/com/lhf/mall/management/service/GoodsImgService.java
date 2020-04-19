package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.GoodsImgEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhf.mall.management.domain.enums.GoodsImgType;

import java.util.List;

/**
 * <p>
 * 商品其他图片 服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-19
 */
public interface GoodsImgService extends IService<GoodsImgEntity> {

    void addGoodsImgs(Long goodsId, List<GoodsImgEntity> imgs, GoodsImgType goodsImgType);

    void deleteGoodsImgs(Long goodsId, GoodsImgType goodsImgType);

    List<GoodsImgEntity> listGoodsImg(Long goodsId, GoodsImgType mainImg);
}
