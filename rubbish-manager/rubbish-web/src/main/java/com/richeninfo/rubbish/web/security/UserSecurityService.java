//package com.richeninfo.rubbish.web.security;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.richeninfo.rubbish.entity.model.User;
//import com.richeninfo.rubbish.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * 密码验证服务，用于spring security验证使用
// */
//@Service
//public class UserSecurityService implements UserDetailsService {
//	private static final Logger logger = LoggerFactory.getLogger(UserSecurityService.class);
//
//	@Autowired
//	private UserService userService;
//
//
//
//	@Override
//	public UserDetails loadUserByUsername(String userName)
//			throws UsernameNotFoundException {
//		logger.debug("登录用户名：", userName);
//
//		String lowercaseLogin = userName.toLowerCase();
//		User query  = new User();
//		query.setLoginName(userName);
//		User user = userService.selectOne(new EntityWrapper<User>(query));
//		if (user == null) {
//			throw new UsernameNotFoundException("用户 " + lowercaseLogin
//					+ " 在数据库不存在");
//		}
//		return new AuthUserDetails(user);
//	}
//}
