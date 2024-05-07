package com.rr.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer.JwtConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rr.jwt.JwtAuthenticationFilter;

//import com.example.demo.auth.AuthService;
//import com.example.demo.jwt.JwtAuthenticationFilter;

import jakarta.servlet.Filter;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
   
	SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter){
		this.jwtAuthenticationFilter=jwtAuthenticationFilter;
	}
	
	//Configuracion de seguridad
	@Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        
		
		return http.csrf(csrf->csrf.disable()).//deshabilitamos el csrf que es la seguridad de spring por defecto 
				authorizeHttpRequests(authRequest -> authRequest.requestMatchers("/auth/**")
				.permitAll() //permite que todas las rutas /auth/** tengan todos los permisos
				.requestMatchers("/swagger-ui/**").permitAll()
				.requestMatchers("/api-docs/**").permitAll()
				.anyRequest()
				.authenticated())//Las demas deben autentificarse
				.sessionManagement(sessionManager->
                sessionManager 
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //ponemos las politicas de creaciones que no guarden estados
             .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();// aplicamos los filtros
            
    }
	
	
	
			
	

}
