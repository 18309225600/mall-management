package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.CustomerEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
public interface CustomerService extends IService<CustomerEntity> {

    CustomerEntity getCustomerByPhone(String customerPhone);
}
