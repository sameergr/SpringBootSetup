package org.test.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.test.boot.security.service.UserValidateService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(new UserValidateService())
		.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/hibernate/**",
						 "/jpa/**",
						 "/test/login",
						 "/test").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginProcessingUrl("/test/j_user_security_check")
			.loginPage("/test/login")
			.failureUrl("/test/login?error=true")
			.defaultSuccessUrl("/test/home", true)
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
		.and()
		.logout()
			.invalidateHttpSession(true)
			.logoutUrl("/test/logout")
			.logoutSuccessUrl("/test/login")
			.deleteCookies("remember-me-cookie")
			.permitAll()
			.and()
			.rememberMe();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("username").password("password").roles("{USER, ADMIN}");
	}
	
	@Bean
	public Md5PasswordEncoder passwordEncoder(){
		return new Md5PasswordEncoder(); 
	}
	
}
