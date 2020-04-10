package com.lhf.mall.management.service.impl;

import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.dao.UserDao;
import com.lhf.mall.management.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
