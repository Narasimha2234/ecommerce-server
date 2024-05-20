package shopping.com.shopping_backend_1.service;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import shopping.com.shopping_backend_1.entity.Customer;
import shopping.com.shopping_backend_1.entity.Seller;

@Service
public class JWTgenerator {
	
	@Value("${jwt.expiration}")
	private int jwtExpiration;
	public String generateToken(Customer customer) {
		Date currentDate=new Date();
		Date expireTime=new Date(currentDate.getTime()+jwtExpiration);
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return Jwts.builder()
				.setSubject(customer.getEmail())
				.claim("id", customer.getId())
				.setIssuedAt(currentDate)
				.setExpiration(expireTime)
				.signWith(secretKey)
				.compact();
	}
	public String generateToken(Seller seller) {
		Date currentDate=new Date();
		Date expireTime=new Date(currentDate.getTime()+jwtExpiration);
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return Jwts.builder()
				.setSubject(seller.getName())
				.claim("id", seller.getId())
				.setIssuedAt(currentDate)
				.setExpiration(expireTime)
				.signWith(secretKey)
				.compact();
	}
}
