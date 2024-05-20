package shopping.com.shopping_backend_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.com.shopping_backend_1.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
Customer findByEmail(String email);
boolean existsByEmail(String email);
}
