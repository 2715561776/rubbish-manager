package com.richeninfo.rubbish.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.richeninfo.rubbish.entity.model.BiddingCompanyInfo;
import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.service.BiddingCompanyInfoService;
import com.richeninfo.rubbish.service.UserService;
import com.richeninfo.rubbish.service.VehicleService;
import com.richeninfo.rubbish.web.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by xuliangjun on 17/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@AutoConfigureMockMvc
public class ControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Resource
    private BiddingCompanyInfoService biddingCompanyInfoService;

    @Resource
    private VehicleService vehicleService;

    @Test
    public void testUserController() throws Exception {
        vehicleService.selectVehicleListWithBiddingCompany(new Page(1,1),new EntityWrapper<>());
        biddingCompanyInfoService.queryBiddingCompanyInfoWithVehicle(new EntityWrapper<>());
        given(this.userService.selectPage(new Page<>(1,10), new EntityWrapper<>()))
                .willReturn(new Page<>());

        this.mvc.perform(get("/user/query"))
                .andExpect(status().isOk());
//                .andExpect(content().string(equalTo("[]")));

        System.out.println("》》》》》》"+content().string(equalTo("[]")));

        this.mvc.perform(get("/user/query")
                .param("loginname", "111111")
                .param("password", "222222"))
                .andExpect(status().isOk());
//                .andExpect(content().string(equalTo("success")));
    }
}