package shopping.com.shopping_backend_1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.com.shopping_backend_1.entity.CartHeader;

public interface CartHeaderRepository extends JpaRepository<CartHeader, Long> {
	 Optional<CartHeader> findByCustomer_Id(Long customerId);
}
