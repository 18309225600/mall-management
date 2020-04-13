package com.lhf.mall.management.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lhf.mall.management.constant.RedisKeyConstant;
import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.dao.UserDao;
import com.lhf.mall.management.domain.std.StdErrorCodeEnum;
import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhf.mall.management.util.RandomUtils;
import com.lhf.mall.management.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
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
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(UserEntity userEntity) {
        UserEntity dbUser = getUserByPhone(userEntity.getPhone());
        if (Objects.nonNull(dbUser)&& dbUser.getPassword().equals(SecurityUtils.md5(userEntity.getPassword()))){
            String token = RandomUtils.randomStr(32);
            log.info("密码正确..登陆成功,token={}",token);
            String tokenRedisKey = MessageFormat.format(RedisKeyConstant.USER_TOKEN, token);
            redisTemplate.opsForValue().set(tokenRedisKey, JSON.toJSONString(dbUser));
            return token;
        }else{
            throw new StdException(StdErrorCodeEnum.MALL_USER_00002);
        }
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
