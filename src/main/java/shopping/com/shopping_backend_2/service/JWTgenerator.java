package shopping.com.shopping_backend_2.service;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import shopping.com.shopping_backend_2.entity.User;

@Service
public class JWTgenerator {
	
	@Value("${jwt.expiration}")
	private int jwtExpiration;
	public String generateToken(User user) {
		Date currentDate=new Date();
		Date expireTime=new Date(currentDate.getTime()+jwtExpiration);
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return Jwts.builder()
				.setSubject(user.getEmail())
				.claim("id", user.getId())
				.claim("role",user.getRole().toString())
				.setIssuedAt(currentDate)
				.setExpiration(expireTime)
				.signWith(secretKey)
				.compact();
	}
	
}
