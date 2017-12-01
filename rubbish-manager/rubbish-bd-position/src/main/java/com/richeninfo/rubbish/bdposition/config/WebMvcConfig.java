package com.richeninfo.rubbish.bdposition.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.*;

/**
 * SpringMVC 配置适配路由和拦截器
 * Created by xuliangjun on 16/06/23.
 */
@SpringBootApplication
@ComponentScan({"com.richeninfo.rubbish.bdposition"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(WebMvcConfig.class);
	}
}