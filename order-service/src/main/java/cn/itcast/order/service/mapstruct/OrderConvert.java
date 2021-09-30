package cn.itcast.order.service.mapstruct;

import cn.itcast.order.domain.Order;
import cn.itcast.order.service.dto.OrderDTO;
import com.google.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderConvert extends BaseMapper<OrderDTO, Order> {
}
