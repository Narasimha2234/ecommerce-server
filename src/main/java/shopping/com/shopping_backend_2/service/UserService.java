package shopping.com.shopping_backend_2.service;

import org.springframework.http.ResponseEntity;

import shopping.com.shopping_backend_2.entity.User;



public interface UserService {

	ResponseEntity<Object> addUser(User user);
	ResponseEntity<Object> loginValidation(User user);
	void deleteUser(String email);
	User updateUser(String email,User user);
}
