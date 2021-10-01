package cn.itcast.order.mapper;

import cn.itcast.order.domain.Order;
import cn.itcast.order.service.dto.OrderDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);

    @Select("SELECT * FROM tb_order")
    List<Order> queryAll();
}
