package cn.itcast.user.mapper;

import cn.itcast.user.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from tb_user where id = #{id}")
//    User findById(@Param("id") Long id);
}
