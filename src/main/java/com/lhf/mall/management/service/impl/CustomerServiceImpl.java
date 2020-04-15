package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lhf.mall.management.domain.CustomerEntity;
import com.lhf.mall.management.dao.CustomerDao;
import com.lhf.mall.management.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {

    @Override
    public CustomerEntity getCustomerByPhone(String customerPhone) {
        LambdaQueryWrapper<CustomerEntity> queryWrapper = new LambdaQueryWrapper<CustomerEntity>()
                .eq(CustomerEntity::getPhone, customerPhone)
                .isNull(CustomerEntity::getDeletedTime);
        return getOne(queryWrapper,false);
    }
}
