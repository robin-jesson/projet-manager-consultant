package com.alten.hercules.auth.service;

import java.security.Key;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

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
	
	
	private static final String SECRET_KEY = "7FC2DFF16D23F8914AD318F7156438AB88371C18A2C8BBC7A767DF9B92";
	private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	/**
	 * Create a token : header is HS256 algorithm; payload is composed of a role and an expiration time, and signature is SECRET_KEY.
	 * @param role the role of the authenticated person
	 * @return token as a string
	 */
	public static String createAuthToken(String role) {
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    
		Calendar expirationSession = Calendar.getInstance();
		expirationSession.add(Calendar.HOUR, 4);
		
		Map<String,Object> payload = new HashMap<String, Object>();
		payload.put("role", role);
		payload.put("exp", expirationSession.getTime());
		
		return Jwts.builder().setClaims(payload).signWith(signatureAlgorithm, signingKey).compact();
		
	
	}
	
	public static Claims readAuthToken(String token) {
		
		try {
			return Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).build().parseClaimsJws(token).getBody();
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
