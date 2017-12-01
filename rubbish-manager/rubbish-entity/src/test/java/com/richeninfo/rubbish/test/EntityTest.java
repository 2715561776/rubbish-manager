package com.richeninfo.rubbish.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.richeninfo.rubbish.entity.EntityApplication;
import com.richeninfo.rubbish.entity.mapper.BiddingCompanyInfoMapper;
import com.richeninfo.rubbish.entity.mapper.UserMapper;
import com.richeninfo.rubbish.entity.mapper.VehicleAppointMapper;
import com.richeninfo.rubbish.entity.model.BiddingCompanyInfo;
import com.richeninfo.rubbish.entity.model.User;
import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.entity.model.VehicleAppoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xuliangjun on 17/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityApplication.class)
public class EntityTest {
    private static final Logger logger = LoggerFactory.getLogger(EntityTest.class);

    @Autowired
    private UserMapper userMapper;

    @Resource
    private VehicleAppointMapper vehicleAppointMapper;

    @Resource
    private BiddingCompanyInfoMapper biddingCompanyInfoMapper;

    @Test
    public void save(){
       /* List<User> list = userMapper.selectPage(new Page<>(0,10), new EntityWrapper<>());
        logger.info("userMapper selectPage success: "+ list.size());*/
//       List<User> list=userMapper.selectList(new EntityWrapper<>());
//       logger.info("userMapper selectPage success: "+ list.size());
//        EntityWrapper<VehicleAppoint> vehicleAppointEntityWrapper=new EntityWrapper<VehicleAppoint>();
//        vehicleAppointEntityWrapper.and("id={0}",10);
//        vehicleAppointMapper.selectVehicleAppointWithPlaceInfo(new Page<VehicleAppoint>(1,10),vehicleAppointEntityWrapper);
//        vehicleAppointMapper.selectByIDDD("10");
        biddingCompanyInfoMapper.queryBiddingCompanyInfoWithVehicle(new EntityWrapper<>());
    }
}
