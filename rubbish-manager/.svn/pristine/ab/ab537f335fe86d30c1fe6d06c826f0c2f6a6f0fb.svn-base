package com.richeninfo.rubbish.weighbridge.config;

import com.itcloudinfo.spring.boot.autoconfigure.mybatis.MybatisPlusConfig;
import com.richeninfo.rubbish.entity.model.VehicleLocu;
import com.richeninfo.rubbish.service.VehicleLocuService;
import com.richeninfo.rubbish.service.VehicleService;
import com.richeninfo.rubbish.weighbridge.MySerialPort;
import com.richeninfo.rubbish.weighbridge.SerialTool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;

/**
 * Created by xuliangjun on 2017/4/4.
 */
@Configuration
@Import({MybatisPlusConfig.class})
@PropertySource(value = {"classpath:database.properties"})
@MapperScan({"com.richeninfo.rubbish.entity.mapper"})
@ComponentScan({"com.richeninfo.rubbish.service","com.richeninfo.rubbish.weighbridge"}) //"com.richeninfo.rubbish.service",
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BeanFactory {

//    @Autowired
//    private MsgProcessService msgProcessService;

    @Resource
    private VehicleLocuService vehicleLocuService;

    @Bean
    public String startPosition(){

        MySerialPort mySerialPort = new MySerialPort(vehicleLocuService);
        mySerialPort.start("COM4",1200);
        return "";
    }
}
