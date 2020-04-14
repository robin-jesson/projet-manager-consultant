package com.alten.hercules.auth.service;

import java.security.Key;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/*
 * 
 * Dans le pom.xml
 * 
 * 
<!-- JWT dependencies -->
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt-api</artifactId>
	<version>0.11.1</version>
</dependency>
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt-impl</artifactId>
	<version>0.11.1</version>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
	<version>0.11.1</version>
	<scope>runtime</scope>
</dependency>
 * 
 * 
 * 
 */
public class TokenAuthService {
	private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String createAuthToken(String role) {
		Calendar expirationSession = Calendar.getInstance();
		expirationSession.add(Calendar.HOUR, 4);
		
		Map<String,Object> payload = new HashMap<String, Object>();
		payload.put("role", role);
		payload.put("exp", expirationSession.getTime());
		
		return Jwts.builder().setClaims(payload).signWith(this.key).compact();
	}
	
	public Claims readAuthToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
}
