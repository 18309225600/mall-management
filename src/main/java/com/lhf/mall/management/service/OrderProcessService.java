package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.OrderProcessEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-18
 */
public interface OrderProcessService extends IService<OrderProcessEntity> {

    List<OrderProcessEntity> listOrderProcessByOrderId(Long orderId);
}
