package shopping.com.shopping_backend_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.com.shopping_backend_1.entity.Customer;
import shopping.com.shopping_backend_1.entity.Products;
import shopping.com.shopping_backend_1.repository.ProductsRepository;
import shopping.com.shopping_backend_1.service.CustomerService;
import shopping.com.shopping_backend_1.service.CustomerServiceImpl;
import shopping.com.shopping_backend_1.service.ProductsService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
		 try {
	            Customer savedCustomer = customerService.addCustomer(customer);
	            return ResponseEntity.ok(savedCustomer); 
	        } catch (IllegalArgumentException e) {
	           
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> customerLoginValidation(@RequestBody Customer customer) {
		
		 return customerService.loginValidation(customer);
		
	}
	
	
	
}
