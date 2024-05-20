package shopping.com.shopping_backend_1.service;

import org.springframework.http.ResponseEntity;

import shopping.com.shopping_backend_1.entity.Seller;

public interface SellerService {
	Seller addSeller(Seller seller);
	void deleteSeller(long id);
	Seller updateseller(Seller seller);
	ResponseEntity<Object> sellerLogin(Seller seller);
}
