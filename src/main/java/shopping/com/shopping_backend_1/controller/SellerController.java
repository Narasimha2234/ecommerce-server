package shopping.com.shopping_backend_1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import shopping.com.shopping_backend_1.dto.ProductDto;
import shopping.com.shopping_backend_1.entity.Products;
import shopping.com.shopping_backend_1.entity.Seller;
import shopping.com.shopping_backend_1.service.ProductsService;
import shopping.com.shopping_backend_1.service.ProductsServiceImpl;
import shopping.com.shopping_backend_1.service.SellerService;
import shopping.com.shopping_backend_1.service.SellerServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("/seller")
@RestController
public class SellerController {
	@Autowired
	SellerService sellerService;
	
	@PostMapping("/register")
	public ResponseEntity<Object> addSeller(@RequestBody Seller seller) {
		try {
			Seller savedSeller=sellerService.addSeller(seller);
			return ResponseEntity.ok(savedSeller);
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		 
	}
	@PostMapping("/login")
	public ResponseEntity<Object> sellerLoginApi(@RequestBody Seller seller) {
		return sellerService.sellerLogin(seller);
		
	}
	
	

	
	
	
}
