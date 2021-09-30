package cn.itcast.user.service.impl.mapstruct;

import cn.itcast.user.domain.User;
import cn.itcast.user.service.impl.dto.UserDTO;
import com.google.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConvert extends BaseMapper<UserDTO, User> {
}
