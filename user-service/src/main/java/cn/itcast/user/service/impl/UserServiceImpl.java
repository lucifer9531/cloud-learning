package cn.itcast.user.service.impl;

import cn.itcast.user.domain.User;
import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.service.UserService;
import cn.itcast.user.service.dto.UserDTO;
import cn.itcast.user.service.mapstruct.UserConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserConvert userConvert;

    @Override
    public UserDTO queryById(Long id) {
        return userConvert.toDto(userMapper.selectById(id));
    }

    @Override
    @Transactional
    public void create(User user) {
        userMapper.insert(user);
    }
}
