package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-10
 */
public interface UserService extends IService<UserEntity> {

    String login(UserEntity userEntity);
}
