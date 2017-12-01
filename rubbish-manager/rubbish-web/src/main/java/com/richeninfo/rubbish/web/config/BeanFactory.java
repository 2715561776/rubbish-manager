package com.richeninfo.rubbish.web.config;

import com.itcloudinfo.spring.boot.autoconfigure.mybatis.MybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by xuliangjun on 2017/4/4.
 */
@Configuration
@Import(MybatisPlusConfig.class)
@PropertySource(value = {"classpath:database.properties"})
@MapperScan({"com.richeninfo.rubbish.entity.mapper"})
@ComponentScan({"com.richeninfo.rubbish"})
public class BeanFactory {

}
