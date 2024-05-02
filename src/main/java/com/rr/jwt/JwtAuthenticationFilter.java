package com.rr.jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rr.auth.AuthService;
import com.rr.user.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private final JwtService jwt_service;
	private UserRepository userRepository;
	
	public JwtAuthenticationFilter(JwtService jwt_service,UserRepository userRepository){
		this.userRepository=userRepository;
		this.jwt_service=jwt_service;
	}

	//el OncePerRequestFilter garantiza que el filtro solo se va a ejecutar una vez
	//que es filterChain?
    // Que es HttpServletResponse	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			
		final String token = getTokenFromRequest(request);
		 final String username;
		
		// Si el token es nulo ...
		if(token == null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		username=jwt_service.getUsernameFromToken(token);
		
		//Si encontro el username y aun no esta autenticado
		if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
			UserDetails user= this.userRepository.findByUsername(username);
			
			 if (jwt_service.isTokenValid(token, user))
	            {
				 //Autoriza al usuario
				 UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(
						 	user,
		                    null,
		                    user.getAuthorities());

		                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
        }
		
		filterChain.doFilter(request, response);
		 
	}

	//Obtiene el token de la peticion
	private String getTokenFromRequest(HttpServletRequest request) {
		final String authHeader= request.getHeader(HttpHeaders.AUTHORIZATION); // obtiene el item de autentificacion del header
		//si el authHeader != null y Empieza con Bearer ....
		if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);// quita del encabezado el "Bearer "
		}
		//Si no retorna null
		return null;
	}

}
