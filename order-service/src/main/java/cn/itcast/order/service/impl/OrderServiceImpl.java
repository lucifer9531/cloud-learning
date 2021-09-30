package cn.itcast.order.service.impl;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.domain.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.domain.Order;
import cn.itcast.order.service.OrderService;
import cn.itcast.order.service.dto.OrderDTO;
import cn.itcast.order.service.mapstruct.OrderConvert;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderConvert orderConvert;
    private final UserClient userClient;

    @Override
    public OrderDTO queryOrderById(Long orderId) {
        // TODO
        // 1.查询订单
        OrderDTO orderDTO = orderConvert.toDto(orderMapper.findById(orderId));
        // 2.用Feign远程调用
        User user = userClient.findById(orderDTO.getUserId());
        // 3.封装user到Order
        orderDTO.setUser(user);
        // 4.返回
        return orderDTO;
    }

    @SentinelResource("goods")
    @Override
    public void queryGoods () {
        System.err.println("查询商品");
    }

    /*@Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.利用RestTemplate发起http请求，查询用户
        // 2.1.url路径
        String url = "http://userservice/user/" + order.getUserId();
        // 2.2.发送http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }*/
}
