package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.GoodsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhf.mall.management.domain.std.Pagination;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
public interface GoodsService extends IService<GoodsEntity> {

    Pagination<GoodsEntity> pageData(Integer pageNo, Integer pageSize);

    GoodsEntity getGoodsById(Long id);

    void add(GoodsEntity goodsEntity);

    void updateGoods(Long id, GoodsEntity goodsEntity);

    void deleteById(Long id);
}
