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
	
	//Generation d'une cle privee HS256
	private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	//Creation du token
	public String createAuthToken(String role) {
		
		//expirationSession contient l'objet "date d'aujourd'hui + 4 heures"
		Calendar expirationSession = Calendar.getInstance();
		expirationSession.add(Calendar.HOUR, 4);
		
		
		//HashMap de la payload
		Map<String,Object> payload = new HashMap<String, Object>();
		
		//Ajout d'éléments dans la payload
		payload.put("role", role);
		payload.put("exp", expirationSession.getTime());
		
		return Jwts.builder().setClaims(payload).signWith(this.key).compact();
	}
	
	//Lecture du token
	public Claims readAuthToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
}
