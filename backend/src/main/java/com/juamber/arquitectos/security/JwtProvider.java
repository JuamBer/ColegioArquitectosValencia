package com.juamber.arquitectos.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;
import com.juamber.arquitectos.models.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generateToken(Authentication auth) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) auth.getPrincipal();
		
		return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public String getNombreUsuarioFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		}catch(MalformedJwtException e) {
			logger.error("MalformedJwtException");
		}catch(UnsupportedJwtException e) {
			logger.error("UnsupportedJwtException");
		}catch(ExpiredJwtException e) {
			logger.error("ExpiredJwtException");
		}catch(IllegalArgumentException e) {
			logger.error("IllegalArgumentException");
		}catch(SignatureException e) {
			logger.error("SignatureException");
		}
		return false;
	}
}
