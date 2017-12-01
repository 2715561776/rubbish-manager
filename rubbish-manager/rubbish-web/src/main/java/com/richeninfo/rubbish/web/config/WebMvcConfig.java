package com.richeninfo.rubbish.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * SpringMVC 配置适配路由和拦截器
 * Created by xuliangjun on 16/06/23.
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	private ApplicationContext applicationContext;
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/", "classpath:/assets/"};

	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(WebMvcConfig.class);
	}

	/**
	 * 配置访问路由
	 * @param registry
     */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	}

	/**
	 * 配置拦截器
	 * @author xlj
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}

	/**
	 * 配置Handers
	 * @author xlj
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}

	/**
	 * 配置springMVC的跨域请求
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}

	/**
	 * 配置自定义的转换器
	 * @param converters
	 */
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		super.configureMessageConverters(converters);
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//		converters.add(fastConverter);
//	}
}