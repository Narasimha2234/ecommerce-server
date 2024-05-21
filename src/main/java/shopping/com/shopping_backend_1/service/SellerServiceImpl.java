package shopping.com.shopping_backend_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import shopping.com.shopping_backend_1.entity.Seller;
import shopping.com.shopping_backend_1.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService{
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	JWTgenerator jwTgenerator;
	
	@Override
	public Seller addSeller(Seller seller) {
		if(sellerRepository.existsByEmail(seller.getEmail())) {
			throw new IllegalArgumentException("email already in use try another");
		}
		return sellerRepository.save(seller);
	}

	@Override
	public void deleteSeller(long id) {
		sellerRepository.deleteById(id);
		
	}

	@Override
	public Seller updateseller(Seller seller) {
		
		return sellerRepository.save(seller);
	}

	@Override
	public ResponseEntity<Object> sellerLogin(Seller seller) {
		Seller existSeller=sellerRepository.findByEmail(seller.getEmail());
		
		if(existSeller!=null) {
			if(existSeller.getPassword().equals(seller.getPassword())){
				
				String token= jwTgenerator.generateToken(existSeller);
				return ResponseEntity.ok(token);
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong Password");
			}	
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Email");
		}
	}

}
