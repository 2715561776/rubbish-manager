package com.richeninfo.rubbish.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * SpringBoot接管Servlet,类似在web.xml中加上spring监听
 * Created by xuliangjun on 15/12/23.
 */
public class InitServletService extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(InitServletService.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(WebMvcConfig.class);
    }


      //显示声明CommonsMultipartResolver为mutipartResolver
       @Bean(name = "multipartResolver")
       public MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
        return resolver;
    }

     /*  @Bean
       public EmbeddedServletContainerCustomizer containerCustomizer(){
           return new MyCustomizer();
       }
       private static class MyCustomizer implements EmbeddedServletContainerCustomizer {
           @Override
           public void customize(ConfigurableEmbeddedServletContainer container) {
               container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND , "/error"));
               container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error"));
           }
       }
*/
}
