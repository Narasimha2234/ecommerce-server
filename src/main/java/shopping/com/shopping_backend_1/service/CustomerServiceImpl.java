package shopping.com.shopping_backend_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import shopping.com.shopping_backend_1.entity.Customer;
import shopping.com.shopping_backend_1.entity.CustomerAddress;
import shopping.com.shopping_backend_1.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
    @Autowired
	JWTgenerator jwTgenerator;
	@Override
	public Customer addCustomer(Customer customer) {
		
		if(customerRepository.existsByEmail(customer.getEmail())) {
			throw new IllegalArgumentException("email already in use try another");
			
		}
		return  customerRepository.save(customer);
	}
	@Override
	public ResponseEntity<Object> loginValidation(Customer customer) {
		
		Customer existsCustomer=customerRepository.findByEmail(customer.getEmail());
		if(existsCustomer!=null) {
			if(existsCustomer.getPassword().equals(customer.getPassword())) {
				String token= jwTgenerator.generateToken(existsCustomer);
				return ResponseEntity.ok(token);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
			}			
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid email");
		}
		
	}
	@Override
	public Customer addAddresstoExistsCustomer(long id, CustomerAddress customerAddress) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteCustomer(String email) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Customer updateCustomer(String email, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
