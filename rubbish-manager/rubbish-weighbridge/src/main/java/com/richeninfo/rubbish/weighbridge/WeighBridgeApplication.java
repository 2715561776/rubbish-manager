package com.richeninfo.rubbish.weighbridge;

//import cn.hylexus.jt808.server.TCPServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WeighBridgeApplication implements EmbeddedServletContainerCustomizer {

	/**
	 * <p>
	 * RUN
	 * <br>
	 * 1、http://localhost:8080/user/test1<br>
	 * 2、http://localhost:8080/user/test2<br>
	 * </p>
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(WeighBridgeApplication.class, args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		for (String profile : activeProfiles) {
			System.out.println(">>>>>>>>>>:Spring Boot 使用profile为:{" + profile + "}");
		}
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
		configurableEmbeddedServletContainer.setPort(8085);
	}
}