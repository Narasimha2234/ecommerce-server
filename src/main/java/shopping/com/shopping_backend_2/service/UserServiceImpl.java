package shopping.com.shopping_backend_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import shopping.com.shopping_backend_2.entity.User;
import shopping.com.shopping_backend_2.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
    @Autowired
	JWTgenerator jwTgenerator;
	@Override
	public ResponseEntity<Object> addUser(User user) {
		
		if(userRepository.existsByEmailAndRole(user.getEmail(), user.getRole())) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("already have an account please login");
		}else {
			return ResponseEntity.ok(userRepository.save(user));
		}
		
	}
	@Override
	public ResponseEntity<Object> loginValidation(User user) {
		User existsUser=userRepository.findByEmailAndRole(user.getEmail(),user.getRole());
		if(existsUser!=null) {
				if(existsUser.getPassword().equals(user.getPassword())) {
					String token= jwTgenerator.generateToken(existsUser);
					return ResponseEntity.ok(token);
				}else {
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
				}
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid email or role");
		}
	}
	@Override
	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User updateUser(String email, User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	
	

}
