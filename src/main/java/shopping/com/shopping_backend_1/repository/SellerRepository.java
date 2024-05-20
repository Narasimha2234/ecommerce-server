package shopping.com.shopping_backend_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.com.shopping_backend_1.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	Seller findByEmail(String email);
	boolean existsByEmail(String email);
}
