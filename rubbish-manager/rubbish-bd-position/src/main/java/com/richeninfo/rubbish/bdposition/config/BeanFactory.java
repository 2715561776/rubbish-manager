package com.richeninfo.rubbish.bdposition.config;

import cn.hylexus.jt808.server.TCPServer;
import com.itcloudinfo.spring.boot.autoconfigure.mybatis.MybatisPlusConfig;
import com.richeninfo.rubbish.bdposition.GeoUtil;
import com.richeninfo.rubbish.bdposition.handler.ServiceHandler;
import com.richeninfo.rubbish.bdposition.service.MsgProcessService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * Created by xuliangjun on 2017/4/4.
 */
@Configuration
@Import({MybatisPlusConfig.class})
@PropertySource(value = {"classpath:database.properties"})
@MapperScan({"com.richeninfo.rubbish.entity.mapper"})
@ComponentScan({"com.richeninfo.rubbish.service","com.richeninfo.rubbish.bdposition"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BeanFactory {

    @Autowired
    private MsgProcessService msgProcessService;

    @Bean
    public TCPServer startPosition(){
        TCPServer server = new TCPServer(8888, new ServiceHandler(msgProcessService));
        server.startServer();
        return server;
    }
}
