package shopping.com.shopping_backend_2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.com.shopping_backend_2.entity.CartHeader;

public interface CartHeaderRepository extends JpaRepository<CartHeader, Long> {
	 Optional<CartHeader> findByUser_Id(Long userId);
}
