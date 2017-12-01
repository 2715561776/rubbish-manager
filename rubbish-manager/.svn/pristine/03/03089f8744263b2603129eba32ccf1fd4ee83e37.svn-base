//package com.richeninfo.rubbish.web.config;
//
//import com.richeninfo.rubbish.service.Md5PasswordEncoder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////	@Autowired
////	private UserSecurityService userSecurityService;
////
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new Md5PasswordEncoder();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//设置安全信息
//		http
//				.csrf()
//				.disable()
//				.headers()
//				.frameOptions()
//				.sameOrigin();
//		//任何角色都可以访问的页面
//		http
//				.authorizeRequests()
//				.antMatchers("/assets/**","/","/login","/loginAction","/index1").permitAll();
//		//页面请求需要授权并设置登录页面
//		http
//				.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				//若禁止form提交(ajax)，使用该设置
////				.disable();
//				//若使用form提交，使用如下配置
//				.loginPage("/login")
//				.loginProcessingUrl("/login")
//				.usernameParameter("loginName")
//				.passwordParameter("password")
//				.defaultSuccessUrl("/index");
//		//设置登出方法
//		http
//
//				.logout()
//				.logoutUrl("/logout")
//				.deleteCookies("JSESSIONID")
//				.permitAll();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		//数据库校验
////		auth
////				.userDetailsService(userSecurityService)
////				.passwordEncoder(passwordEncoder());
//
//		//内存校验
////		auth
////				.inMemoryAuthentication()
////				.withUser("admin").password("admin123").roles("USER");
//	}
//
//}