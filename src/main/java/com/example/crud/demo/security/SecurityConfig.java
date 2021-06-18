package com.example.crud.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user01").password(passwordEncoder().encode("user")).roles("USER").and()
				.withUser("user02").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/crud/getAll", "/crud/save").hasRole("ADMIN").antMatchers("/crud/get")
				.hasRole("USER")
				.anyRequest().authenticated()
				.and()
				.csrf().disable()
				.formLogin();
	}

}
