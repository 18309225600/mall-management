package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.GoodsSpecificationEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-20
 */
public interface GoodsSpecificationService extends IService<GoodsSpecificationEntity> {

    List<GoodsSpecificationEntity> listSpecificationByGoodsId(Long goodsId);

    void configSpecification(Long goodsId, List<GoodsSpecificationEntity> goodsSpecificationEntity);
}
