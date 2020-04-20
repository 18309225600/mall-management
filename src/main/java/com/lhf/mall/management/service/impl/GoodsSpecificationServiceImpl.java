package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lhf.mall.management.domain.GoodsSpecificationEntity;
import com.lhf.mall.management.dao.GoodsSpecificationDao;
import com.lhf.mall.management.service.GoodsSpecificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-20
 */
@Service
public class GoodsSpecificationServiceImpl extends ServiceImpl<GoodsSpecificationDao, GoodsSpecificationEntity> implements GoodsSpecificationService {

    @Override
    public List<GoodsSpecificationEntity> listSpecificationByGoodsId(Long goodsId) {
        LambdaQueryWrapper<GoodsSpecificationEntity> queryWrapper = new LambdaQueryWrapper<GoodsSpecificationEntity>()
                .eq(GoodsSpecificationEntity::getGoodsId, goodsId)
                .isNull(GoodsSpecificationEntity::getDeletedTime);
        return list(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void configSpecification(Long goodsId, List<GoodsSpecificationEntity> goodsSpecificationEntity) {
        List<GoodsSpecificationEntity> dbSpecification = listSpecificationByGoodsId(goodsId);
        if (!CollectionUtils.isEmpty(dbSpecification)){
            dbSpecification.forEach(specification-> specification.setDeletedTime(LocalDateTime.now()));
            updateBatchById(dbSpecification);
        }

        if (!CollectionUtils.isEmpty(goodsSpecificationEntity)){
            goodsSpecificationEntity.forEach(specification->{specification.setId(null);specification.setGoodsId(goodsId);specification.setCreateTime(LocalDateTime.now());});
            saveBatch(goodsSpecificationEntity);
        }
    }
}
