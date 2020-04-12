package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-10
 */
public interface UserService extends IService<UserEntity> {

    UserEntity login(UserEntity userEntity);

    List<UserEntity> listData();
}
