package cn.itcast.order.confg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.itcast.order.mapper")
public class MybatisConfig {
}
