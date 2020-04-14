package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhf.mall.management.domain.std.Pagination;

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

    String login(UserEntity userEntity);

    List<UserEntity> listData();

    UserEntity userInfo();

    Pagination<UserEntity> pageUsers(String name, String phone, Integer pageNo, Integer pageSize);

    void add(UserEntity userEntity);

    void delete(Long id);
}
