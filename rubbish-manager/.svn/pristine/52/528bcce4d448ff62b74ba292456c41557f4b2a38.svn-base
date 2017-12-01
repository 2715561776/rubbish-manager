package com.richeninfo.rubbish.weighbridge.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringMVC 配置适配路由和拦截器
 * Created by xuliangjun on 16/06/23.
 */
@SpringBootApplication
@ComponentScan({"com.richeninfo.rubbish.weighbridge"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(WebMvcConfig.class);
	}
}