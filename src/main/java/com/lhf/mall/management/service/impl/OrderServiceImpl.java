package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhf.mall.management.domain.CustomerEntity;
import com.lhf.mall.management.domain.GoodsEntity;
import com.lhf.mall.management.domain.OrderEntity;
import com.lhf.mall.management.dao.OrderDao;
import com.lhf.mall.management.domain.OrderProcessEntity;
import com.lhf.mall.management.domain.enums.OrderProcessType;
import com.lhf.mall.management.domain.enums.OrderStatus;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.domain.std.StdErrorCodeEnum;
import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.dto.OrderDetailDto;
import com.lhf.mall.management.dto.OrderDto;
import com.lhf.mall.management.service.CustomerService;
import com.lhf.mall.management.service.GoodsService;
import com.lhf.mall.management.service.OrderProcessService;
import com.lhf.mall.management.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhf.mall.management.util.ConvertUtils;
import com.lhf.mall.management.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderProcessService orderProcessService;

    @Override
    public Pagination<OrderEntity> pageOrder(Integer pageNo, Integer pageSize) {
        LambdaQueryWrapper<OrderEntity> queryWrapper = new LambdaQueryWrapper<OrderEntity>()
                .isNull(OrderEntity::getDeletedTime);

        IPage<OrderEntity> page = page(new Page<>(pageNo, pageSize), queryWrapper);
        return new Pagination<>(page.getTotal(),page.getRecords());
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        LambdaQueryWrapper<OrderEntity> queryWrapper = new LambdaQueryWrapper<OrderEntity>()
                .eq(OrderEntity::getId, id)
                .isNull(OrderEntity::getDeletedTime);
        return getOne(queryWrapper,false);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addOrder(OrderDto orderDto) {
        GoodsEntity goods = goodsService.getGoodsById(orderDto.getGoodsId());
        if (Objects.isNull(goods)){
            throw new StdException();
        }
        CustomerEntity customerEntity = customerService.getCustomerByPhone(orderDto.getCustomerPhone());
        if (Objects.isNull(customerEntity)){
            customerEntity = new CustomerEntity();
            customerEntity.setName(orderDto.getCustomerName())
                    .setPhone(orderDto.getCustomerPhone())
                    .setCountry(goods.getCountry())
                    .setProvince(orderDto.getCustomerProvince())
                    .setCity(orderDto.getCustomerCity())
                    .setAddress(orderDto.getCustomerAddress())
                    .setEmail(orderDto.getCustomerEmail())
                    .setCreateTime(LocalDateTime.now());
            customerService.save(customerEntity);
        }

        OrderEntity orderEntity = ConvertUtils.sourceToTarget(orderDto, OrderEntity.class);

        orderEntity.setCustomerId(customerEntity.getId())
                .setOrderNo(getOrderNo())
                .setCustomerCountry(goods.getCountry())
                .setAmount(goods.getSpecialOffer())
                .setAmoutCurrencySymbol(goods.getCurrencySymbol())
                .setGoodsId(goods.getId())
                .setStatus(OrderStatus.UN_PURCHASE.getCode())
                .setCreateTime(LocalDateTime.now());
        save(orderEntity);
        return orderEntity.getId();
    }

    /**
     * 获取订单编号
     * @return
     */

    private String getOrderNo() {
        String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return localTime+RandomUtils.randomNum(3);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrderById(Long id, OrderEntity orderEntity) {
        OrderEntity dbOrder = getOrderByIdForUpdate(id);
        if (Objects.isNull(dbOrder)){
            throw new StdException(StdErrorCodeEnum.MALL_ORDER_00001);
        }

        orderEntity.setId(id);
        updateById(orderEntity);
    }

    @Override
    public OrderDetailDto getOrderDetail(Long id) {
        List<OrderProcessEntity> orderProcessEntityList = orderProcessService.listOrderProcessByOrderId(id);
        OrderEntity orderEntity = getOrderById(id);

        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrder(orderEntity);
        orderDetailDto.setOrderProcess(orderProcessEntityList);
        return orderDetailDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRemark(Long id, OrderDto orderDto) {
        OrderProcessEntity orderProcessEntity = new OrderProcessEntity();
        orderProcessEntity.setOrderId(id)
                .setType(OrderProcessType.ADD_REMARK.getCode())
                .setRemark(orderDto.getRemark())
                .setCreateTime(LocalDateTime.now());
        orderProcessService.save(orderProcessEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(Long id, OrderDto orderDto) {
        OrderEntity orderEntity = getOrderById(id);
        if (Objects.isNull(orderEntity)){
            throw new StdException(StdErrorCodeEnum.MALL_ORDER_00001);
        }

        orderEntity.setStatus(orderDto.getStatus());
        updateById(orderEntity);

        OrderProcessEntity orderProcessEntity = new OrderProcessEntity();
        orderProcessEntity.setOrderId(id)
                .setType(OrderProcessType.UPDATE_STATUS.getCode())
                .setOrderStatus(OrderStatus.codeOf(orderDto.getStatus()).getDescription())
                .setCreateTime(LocalDateTime.now());
        orderProcessService.save(orderProcessEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDelivery(Long id, OrderDto orderDto) {
        OrderEntity orderEntity = getOrderById(id);
        if (Objects.isNull(orderEntity)){
            throw new StdException(StdErrorCodeEnum.MALL_ORDER_00001);
        }

        orderEntity.setDeliveryCompany(orderDto.getDeliveryCompany())
                .setDeliveryNum(orderDto.getDeliveryNum());
        updateById(orderEntity);

        OrderProcessEntity orderProcessEntity = new OrderProcessEntity();
        orderProcessEntity.setOrderId(id)
                .setType(OrderProcessType.WRITE_DELIVERY_INFO.getCode())
                .setDeliveryCompany(orderDto.getDeliveryCompany())
                .setDeliveryNum(orderDto.getDeliveryNum())
                .setCreateTime(LocalDateTime.now());
        orderProcessService.save(orderProcessEntity);
    }

    private OrderEntity getOrderByIdForUpdate(Long id) {
        LambdaQueryWrapper<OrderEntity> queryWrapper = new LambdaQueryWrapper<OrderEntity>()
                .eq(OrderEntity::getId, id)
                .isNull(OrderEntity::getDeletedTime)
                .last(" FOR UPDATE ");
        return getOne(queryWrapper,false);
    }
}
