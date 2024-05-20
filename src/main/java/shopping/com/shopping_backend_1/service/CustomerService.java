package shopping.com.shopping_backend_1.service;

import org.springframework.http.ResponseEntity;

import shopping.com.shopping_backend_1.entity.Customer;
import shopping.com.shopping_backend_1.entity.CustomerAddress;


public interface CustomerService {

	Customer addCustomer(Customer customer);
	ResponseEntity<Object> loginValidation(Customer customer);
	Customer addAddresstoExistsCustomer(long id,CustomerAddress customerAddress);
	void deleteCustomer(String email);
	Customer updateCustomer(String email,Customer customer);
}
