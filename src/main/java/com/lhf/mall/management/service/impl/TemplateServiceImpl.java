package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lhf.mall.management.domain.TemplateEntity;
import com.lhf.mall.management.dao.TemplateDao;
import com.lhf.mall.management.service.TemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-16
 */
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateDao, TemplateEntity> implements TemplateService {

    @Override
    public List<TemplateEntity> listTemplates() {
        LambdaQueryWrapper<TemplateEntity> queryWrapper = new LambdaQueryWrapper<TemplateEntity>()
                .isNull(TemplateEntity::getDeletedTime);
        return list(queryWrapper);
    }

    @Override
    public TemplateEntity getTemplateById(Long templateId) {
        LambdaQueryWrapper<TemplateEntity> queryWrapper = new LambdaQueryWrapper<TemplateEntity>()
                .eq(TemplateEntity::getId, templateId)
                .isNull(TemplateEntity::getDeletedTime);
        return getOne(queryWrapper,false);
    }
}
