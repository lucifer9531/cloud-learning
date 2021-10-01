package cn.itcast.order.domain;

import cn.itcast.feign.domain.User;
import lombok.*;

@Data
@ToString
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    // 关联用户信息
    private Long userId;
    private User user;
}
