package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.google.common.collect.Lists;
import com.lhf.mall.management.domain.GoodsImgEntity;
import com.lhf.mall.management.dao.GoodsImgDao;
import com.lhf.mall.management.domain.enums.GoodsImgType;
import com.lhf.mall.management.service.GoodsImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品其他图片 服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-19
 */
@Service
public class GoodsImgServiceImpl extends ServiceImpl<GoodsImgDao, GoodsImgEntity> implements GoodsImgService {

    @Override
    public void addGoodsImgs(Long goodsId, List<GoodsImgEntity> imgs, GoodsImgType goodsImgType) {
        if(CollectionUtils.isEmpty(imgs)){
            return ;
        }
        ArrayList<GoodsImgEntity> addContainer = Lists.newArrayListWithCapacity(imgs.size());
        imgs.forEach(img->{
            GoodsImgEntity goodsImgEntity = new GoodsImgEntity();
            goodsImgEntity.setGoodsId(goodsId)
                    .setType(goodsImgType.getCode())
                    .setUrl(img.getUrl())
                    .setCreateTime(LocalDateTime.now());
            addContainer.add(goodsImgEntity);
        });
        saveBatch(addContainer);
    }

    @Override
    public void deleteGoodsImgs(Long goodsId, GoodsImgType goodsImgType) {
        LambdaUpdateWrapper<GoodsImgEntity> updateWrapper = new LambdaUpdateWrapper<GoodsImgEntity>()
                .eq(GoodsImgEntity::getGoodsId, goodsId)
                .eq(GoodsImgEntity::getType, goodsImgType.getCode())
                .set(GoodsImgEntity::getDeletedTime, LocalDateTime.now());
        update(updateWrapper);
    }

    @Override
    public List<GoodsImgEntity> listGoodsImg(Long goodsId, GoodsImgType goodsImgType) {
        LambdaQueryWrapper<GoodsImgEntity> queryWrapper = new LambdaQueryWrapper<GoodsImgEntity>()
                .eq(GoodsImgEntity::getGoodsId, goodsId)
                .eq(GoodsImgEntity::getType, goodsImgType.getCode())
                .isNull(GoodsImgEntity::getDeletedTime);
        return list(queryWrapper);
    }
}
