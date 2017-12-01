package com.richeninfo.rubbish.web;

//import cn.hylexus.jt808.server.TCPServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebApplication{

	/**
	 * <p>
	 * RUN
	 * <br>
	 * 1、http://localhost:8080/user/test1<br>
	 * 2、http://localhost:8080/user/test2<br>
	 * </p>
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(WebApplication.class, args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		for (String profile : activeProfiles) {
			System.out.println(">>>>>>>>>>:Spring Boot 使用profile为:{" + profile + "}");
		}
	}
}