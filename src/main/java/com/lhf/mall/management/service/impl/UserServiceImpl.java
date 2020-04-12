package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.dao.UserDao;
import com.lhf.mall.management.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public UserEntity login(UserEntity userEntity) {
        UserEntity dbUser = getUserByPhone(userEntity.getPhone());
        if (Objects.nonNull(dbUser)&&dbUser.getPassword().equals(userEntity.getPassword())){
            return dbUser;
        }
        return null;
    }

    @Override
    public List<UserEntity> listData() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>()
                .isNull(UserEntity::getDeletedTime);
        return list(queryWrapper);
    }

    private UserEntity getUserByPhone(String phone) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getPhone, phone)
                .isNull(UserEntity::getDeletedTime);
        return getOne(queryWrapper,false);
    }
}
