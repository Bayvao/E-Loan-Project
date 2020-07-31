package com.elaon.config;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class EloanSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ...
		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/manager/**").hasRole("MANAGER")
				.antMatchers("/editForm/**").hasAnyRole("ADMIN", "MANAGER")
				.antMatchers("/loan/**").hasAnyRole("MANAGER", "ADMIN", "CLERK")
				.antMatchers("/").hasAnyRole("MANAGER", "ADMIN", "CLERK")
				.antMatchers("/resources/**").permitAll()
				.and()
				.formLogin()
					.loginPage("/showLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
					.rememberMe() //default to 2 weeks
					.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)) // changing default value to 21 days
					.key("somethingverysecured")
				.and()
				.logout()
					.permitAll()
					.and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

	@Bean
	public UserDetailsManager userDetailsManager() {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

		jdbcUserDetailsManager.setDataSource(securityDataSource);

		return jdbcUserDetailsManager;
	}

}
