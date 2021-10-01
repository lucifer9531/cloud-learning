package cn.itcast.order.service;

import cn.itcast.order.service.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    /**
     * 查询订单
     * @param orderId
     * @return
     */
    OrderDTO queryOrderById(Long orderId);

    /**
     * 查询商品
     */
    void queryGoods ();

    /**
     * 查询全部商品
     * @return
     */
    List<OrderDTO> queryAll();
}
