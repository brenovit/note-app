package br.com.friends.noteapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN")
			.and()
			.withUser("user").password(encoder().encode("userPass")).roles("USER");
	}
	
	/*@Override
	protected configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(restAuthenticationEntryPoint)
		.and()
		.formLogin()
		.successHandler(mySuccessHandler)
		.failureHandler(myFailureHandler)
		.and()
		.loggout();
	}*/
	
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
