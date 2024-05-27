package shopping.com.shopping_backend_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.com.shopping_backend_2.config.Role;
import shopping.com.shopping_backend_2.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
User findByEmailAndRole(String email,Role role);
boolean existsByEmailAndRole(String email,Role role);
}
