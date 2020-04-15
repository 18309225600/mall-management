package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhf.mall.management.domain.GoodsEntity;
import com.lhf.mall.management.dao.GoodsDao;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.domain.std.StdErrorCodeEnum;
import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Override
    public Pagination<GoodsEntity> pageData(Integer pageNo, Integer pageSize) {
        LambdaQueryWrapper<GoodsEntity> queryWrapper = new LambdaQueryWrapper<GoodsEntity>()
                .isNull(GoodsEntity::getDeletedTime);

        IPage<GoodsEntity> page = page(new Page<>(pageNo, pageSize), queryWrapper);
        return new Pagination<>(page.getTotal(),page.getRecords());
    }

    @Override
    public GoodsEntity getGoodsById(Long id) {
        LambdaQueryWrapper<GoodsEntity> queryWrapper = new LambdaQueryWrapper<GoodsEntity>()
                .eq(GoodsEntity::getId, id)
                .isNull(GoodsEntity::getDeletedTime);
        return getOne(queryWrapper,false);
    }

    @Override
    public void add(GoodsEntity goodsEntity) {
        goodsEntity.setCreateTime(LocalDateTime.now());
        save(goodsEntity);
    }

    @Override
    public void updateGoods(Long id, GoodsEntity goodsEntity) {
        GoodsEntity dbGoods = getByIdForUpdate(id);
        if (Objects.isNull(dbGoods)){
            throw new StdException(StdErrorCodeEnum.MALL_GOODS_00001);
        }

        goodsEntity.setId(id);
        updateById(goodsEntity);
    }

    private GoodsEntity getByIdForUpdate(Long id) {
        LambdaQueryWrapper<GoodsEntity> queryWrapper = new LambdaQueryWrapper<GoodsEntity>()
                .eq(GoodsEntity::getId, id)
                .isNull(GoodsEntity::getDeletedTime)
                .last(" FOR UPDATE ");
        return getOne(queryWrapper,false);
    }

    @Override
    public void deleteById(Long id) {
        GoodsEntity dbGoods = getByIdForUpdate(id);

        if (Objects.isNull(dbGoods)){
            throw new StdException(StdErrorCodeEnum.MALL_GOODS_00001);
        }

        dbGoods.setDeletedTime(LocalDateTime.now());
        updateById(dbGoods);
    }
}
