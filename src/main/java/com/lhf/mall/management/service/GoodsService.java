package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.GoodsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.dto.GoodsDto;

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

    void add(GoodsDto goodsDto);

    void updateGoods(Long id, GoodsDto goodsDto);

    void deleteById(Long id);

    GoodsDto detail(Long id);
}
