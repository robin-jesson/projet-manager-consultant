package com.alten.hercules.auth.service;

import java.security.Key;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;

public class TokenManager {
	
	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	
	public static String createAuthToken(String role) {
		Calendar expirationSession = Calendar.getInstance();
		expirationSession.add(Calendar.HOUR, 4);
		
		Map<String,Object> payload = new HashMap<String, Object>();
		payload.put("role", role);
		payload.put("exp", expirationSession.getTime());
		
		return Jwts.builder().setClaims(payload).signWith(key).compact();
	}
	
	public static Claims readAuthToken(String token) {
		
		try {
			return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		} catch (InvalidKeyException e) {  
			System.err.println("Key error. Error code : " + e.getMessage());
			e.printStackTrace();
		} catch (SignatureException e) {
			System.err.println("Signature error. Error code : " + e.getMessage());
			e.printStackTrace();
		} catch (MissingClaimException e) {
			System.err.println("Missing value in token. Error code : " + e.getMessage());
			e.printStackTrace();
		} catch (IncorrectClaimException e) {
			System.err.println("Incorrect claim. Error code  : " + e.getMessage());
			e.printStackTrace();
		} catch (JwtException e) {
			System.err.println("Generic token error. Error code  : " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
