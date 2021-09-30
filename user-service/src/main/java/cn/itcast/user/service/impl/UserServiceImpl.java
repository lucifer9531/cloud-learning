package cn.itcast.user.service.impl;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.service.UserService;
import cn.itcast.user.service.impl.dto.UserDTO;
import cn.itcast.user.service.impl.mapstruct.UserConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserConvert userConvert;

    @Override
    public UserDTO queryById(Long id) {
        return userConvert.toDto(userMapper.findById(id));
    }
}
