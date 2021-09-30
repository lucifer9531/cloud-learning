package cn.itcast.user.service;

import cn.itcast.user.service.impl.dto.UserDTO;

public interface UserService {
    UserDTO queryById(Long id);
}
