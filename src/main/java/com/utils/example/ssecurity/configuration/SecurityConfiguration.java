package com.utils.example.ssecurity.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;


@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	Logger logger =  LoggerFactory.getLogger(SecurityConfiguration.class);
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//BCryptPasswordEncoder bcEncoder = new BCryptPasswordEncoder(); //Springboot 4
		log.info("Initiating security validation..");
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("usuario").password(encoder.encode("password")).roles("USER");
		log.info("Ending authentication...");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().antMatchers("/testapi").hasRole("USER").anyRequest().denyAll();
//		http.authorizeRequests().antMatchers("/hello").hasAnyRole("USER","ADMIN").and().formLogin();
//		http.authorizeRequests().anyRequest().authenticated();
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		BCryptPasswordEncoder bcEncoder = new BCryptPasswordEncoder();
//		InMemoryUserDetailsManager detailsManager= new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("gmtzs").password("lpe550211").build();
//		detailsManager.createUser(user);
//		auth.userDetailsService(detailsManager);
//	}
	
}
