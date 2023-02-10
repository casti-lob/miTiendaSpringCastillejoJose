package com.jacaranda.tienda.securiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jacaranda.tienda.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserService myUserDetailService;

// Indicamos que la configuración se hará a travéx del servicio.
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailService);
	}

// Método que usaremos más abajo
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserService();
	}
   
// Método que nos suministrará la codificación
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

// Método que autentifica
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	// Aquí es donde podemos especificar qué es lo que hace y lo que no
	// según el rol del usuario
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	throws Exception {
	http.authorizeHttpRequests((requests) -> {
	requests.requestMatchers("/css").permitAll()
	
	.requestMatchers("/").permitAll()
	.requestMatchers("/sing_up").permitAll()
	.requestMatchers("/elements/**").permitAll()
	
	.requestMatchers("/addStudent").permitAll()
	.requestMatchers("/editStudent/**").permitAll()
	.requestMatchers("/delStudent/**").permitAll()
	.requestMatchers("/register").permitAll()
	.requestMatchers("/process_register").permitAll()
	.anyRequest().authenticated();
	}).formLogin((form) -> form
	// .loginPage("/process_register")
	.permitAll())
	.logout((logout) -> logout.permitAll());
	return http.build();
	}
}

