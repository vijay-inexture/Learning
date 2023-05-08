package com.learning.springMvc.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.learning.springMvc.config.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity//(debug=true)
@ComponentScan({"com.learning.springMvc"})
public class WebSecurityConfig{
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {	
		http.authorizeHttpRequests((requests) -> requests
				  .requestMatchers("/","/forgotPassword", "/createNew").permitAll()
				  .requestMatchers(HttpMethod.POST,"/users").permitAll()
				  .requestMatchers("/users").hasAuthority("ADMIN")
				  .requestMatchers("/users/{userId}/deleteUser").hasAuthority("ADMIN")
//				  .requestMatchers(HttpMethod.GET,"/users/{userId}").hasAnyAuthority("USER","ADMIN") 
//				  .requestMatchers("/users/{userId}/updateUser").hasAnyAuthority("USER","ADMIN") ///users/{userId}/address
			      .anyRequest().authenticated())
				  .formLogin((form) -> form
						.loginPage("/login")
						.failureUrl("/login?error=true")
						.permitAll()
					)
					.logout((logout) -> logout
			                .logoutUrl("/logout")
			                .logoutSuccessUrl("/login?logout=true")
			                .invalidateHttpSession(true)
			                .deleteCookies("JSESSIONID").permitAll());
			      return http.build();
	}
	
}
