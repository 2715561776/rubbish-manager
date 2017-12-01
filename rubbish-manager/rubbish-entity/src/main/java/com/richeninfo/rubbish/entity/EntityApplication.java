package com.richeninfo.rubbish.entity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:database.properties"})
@MapperScan("com.richeninfo.rubbish.entity.mapper")
public class EntityApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(EntityApplication.class, args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		for (String profile : activeProfiles) {
			System.out.println(">>>>>>>>>>:Spring Boot 使用profile为:{" + profile + "}");
		}
	}
}
