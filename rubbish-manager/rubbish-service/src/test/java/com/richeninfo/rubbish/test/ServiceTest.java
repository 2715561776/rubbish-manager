package com.richeninfo.rubbish.test;

import com.richeninfo.rubbish.ServiceApplication;
import com.richeninfo.rubbish.entity.model.User;
import com.richeninfo.rubbish.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by xuliangjun on 17/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testUserService() throws Exception {
        User user = new User();
        user.setUserName("test");
        user.setPostName("11111");
        user.setLoginName("t1@test.com");
        user.setPassword("123");
        user.setStatus("123");
        user.setCreatedBy("123");
        user.setCreatedTime(new Date());
        userService.insert(user);
    }
}