package shopping.com.shopping_backend_2.controller;

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

import shopping.com.shopping_backend_2.entity.Products;
import shopping.com.shopping_backend_2.entity.User;
import shopping.com.shopping_backend_2.repository.ProductsRepository;
import shopping.com.shopping_backend_2.service.ProductsService;
import shopping.com.shopping_backend_2.service.UserService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public ResponseEntity<Object> saveCustomer(@RequestBody User user) {
		return userService.addUser(user);
		
	}
	
	@PostMapping("login")
	public ResponseEntity<Object> customerLoginValidation(@RequestBody User user) {
		
		 return userService.loginValidation(user);
		
	}
	
	
	
}
