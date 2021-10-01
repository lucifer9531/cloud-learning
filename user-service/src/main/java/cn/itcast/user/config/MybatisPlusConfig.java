package cn.itcast.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.itcast.user.mapper")
public class MybatisPlusConfig {
}
