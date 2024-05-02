package com.rr.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.rr.user.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
	
	public String secret_key = "9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";

	
	//Obtenemos el token
	public String getToken(User user) {
		return getToken (new HashMap<>(), user);
	}

	//Generamos el token
	private String getToken(Map<String,Object> extraClaims,User user) {
		
		return Jwts.builder().setClaims(extraClaims).setSubject(user.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
				.signWith(getKey(),SignatureAlgorithm.HS256).compact();
	}

	//Obtenemos una Key utilizando la secret_key
	private Key getKey() {
		byte[] keyBytes= Decoders.BASE64.decode(secret_key);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	//Comprueba si el token es valido por el usuario y la fecha de expiracion
	public boolean isTokenValid(String token, UserDetails user) {
		final String username=getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
		
	}
	//Comprueba que la fecha de expiracion
	private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }

	//Obtiene la fecha de expiracion del token
	private Date getExpiration(String token)
	    {
	        return getClaim(token, Claims::getExpiration);
	    }
	
	//Metodo que se adapta dependiendo de la funcion que se solicite para obtener cada parte del token
	 public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
	    {
	        final Claims claims=getAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	 
	 //obtine todas las partes del token
	 private Claims getAllClaims(String token)
	    {
	        return Jwts
	            .parserBuilder()
	            .setSigningKey(getKey())
	            .build()
	            .parseClaimsJws(token)
	            .getBody();
	    }
	 //Obtiene el nombre de usurio del token 
	public String getUsernameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
		}
	
	

}
