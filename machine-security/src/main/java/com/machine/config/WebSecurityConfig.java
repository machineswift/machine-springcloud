package com.machine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description: DruidConfig
 *
 * @author machine
 * @date 2017年12月18日 上午12:53:53
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/* 所有的请求都要进行认证 */
		httpSecurity.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();

		/* 所有的rest服务设置为无状态的 */
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new MachinePasswordEncoder()).withUser("machine")
				.password("machine").roles("USER");
	}
}

/**
 * @Description: 自定义密码编码器
 *
 * @author machine
 * @date 2018年01月15日 上午12:53:53
 */
class MachinePasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(rawPassword.toString());
	}
}