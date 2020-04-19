package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhf.mall.management.domain.GoodsEntity;
import com.lhf.mall.management.dao.GoodsDao;
import com.lhf.mall.management.domain.GoodsImgEntity;
import com.lhf.mall.management.domain.TemplateEntity;
import com.lhf.mall.management.domain.enums.GoodsImgType;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.domain.std.StdErrorCodeEnum;
import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.dto.GoodsDto;
import com.lhf.mall.management.service.GoodsImgService;
import com.lhf.mall.management.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhf.mall.management.service.TemplateService;
import com.lhf.mall.management.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
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

    @Autowired
    private TemplateService  templateService;
    @Autowired
    private GoodsImgService goodsImgService;

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
    @Transactional(rollbackFor = Exception.class)
    public void add(GoodsDto goodsDto) {
        GoodsEntity goodsEntity = ConvertUtils.sourceToTarget(goodsDto, GoodsEntity.class);
        if (Objects.nonNull(goodsDto.getTemplateId())){
            TemplateEntity templateEntity = templateService.getTemplateById(goodsDto.getTemplateId());
            if (Objects.nonNull(templateEntity)){
                goodsEntity.setCurrencySymbol(templateEntity.getCurrencySymbol())
                        .setTemplateName(templateEntity.getName());
            }
        }
        goodsEntity.setCreateTime(LocalDateTime.now());
        save(goodsEntity);

        //添加主图和参数图
        List<GoodsImgEntity> mainImg = goodsDto.getMainImg();
        List<GoodsImgEntity> productParamImg = goodsDto.getProductParamImg();
        goodsImgService.addGoodsImgs(goodsEntity.getId(),mainImg, GoodsImgType.MAIN_IMG);
        goodsImgService.addGoodsImgs(goodsEntity.getId(),productParamImg, GoodsImgType.PARAM_IMG);
    }

    @Override
    public void updateGoods(Long id, GoodsDto goodsDto) {
        GoodsEntity dbGoods = getByIdForUpdate(id);
        if (Objects.isNull(dbGoods)){
            throw new StdException(StdErrorCodeEnum.MALL_GOODS_00001);
        }

        GoodsEntity goodsEntity = ConvertUtils.sourceToTarget(goodsDto, GoodsEntity.class);
        if (Objects.nonNull(goodsDto.getTemplateId()) && !goodsDto.getTemplateId().equals( dbGoods.getTemplateId())){
            TemplateEntity templateEntity = templateService.getTemplateById(goodsDto.getTemplateId());
            if (Objects.nonNull(templateEntity)){
                goodsEntity.setCurrencySymbol(templateEntity.getCurrencySymbol())
                        .setTemplateName(templateEntity.getName());
            }
        }

        goodsEntity.setId(id);
        updateById(goodsEntity);

        //删除原有的主图和参数图
        goodsImgService.deleteGoodsImgs(id,GoodsImgType.MAIN_IMG);
        goodsImgService.deleteGoodsImgs(id,GoodsImgType.PARAM_IMG);
        //添加主图和参数图
        List<GoodsImgEntity> mainImg = goodsDto.getMainImg();
        List<GoodsImgEntity> productParamImg = goodsDto.getProductParamImg();
        goodsImgService.addGoodsImgs(goodsEntity.getId(),mainImg, GoodsImgType.MAIN_IMG);
        goodsImgService.addGoodsImgs(goodsEntity.getId(),productParamImg, GoodsImgType.PARAM_IMG);
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

    @Override
    public GoodsDto detail(Long id) {
        GoodsEntity goodsEntity = getGoodsById(id);
        List<GoodsImgEntity> mainImgs = goodsImgService.listGoodsImg(id,GoodsImgType.MAIN_IMG);
        List<GoodsImgEntity> paramImgs = goodsImgService.listGoodsImg(id,GoodsImgType.PARAM_IMG);

        GoodsDto goodsDto = ConvertUtils.sourceToTarget(goodsEntity, GoodsDto.class);
        goodsDto.setMainImg(mainImgs);
        goodsDto.setProductParamImg(paramImgs);
        return goodsDto;
    }
}
