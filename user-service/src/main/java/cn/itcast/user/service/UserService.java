package cn.itcast.user.service;

import cn.itcast.user.domain.User;
import cn.itcast.user.service.dto.UserDTO;

public interface UserService {
    UserDTO queryById(Long id);

    void create(User user);

    void update(User user);
}
