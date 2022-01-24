package com.aviationfuelinvoiceapp.aviationfuelinvoice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/airlines/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/invoices/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/airlines/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/invoices/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/airlines/delete").hasRole("ADMIN")
			.antMatchers("/invoices/delete").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/employees/**").hasRole("EMPLOYEE")
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/index")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
		
}






