package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.TemplateEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-16
 */
public interface TemplateService extends IService<TemplateEntity> {

    List<TemplateEntity> listTemplates();
}
