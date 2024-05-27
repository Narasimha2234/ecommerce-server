package shopping.com.shopping_backend_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.com.shopping_backend_2.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
	List<Products> findBySellerId(long id);
	List<Products> findByCategory(String category);
	Products findByIdAndSellerId(long id,long userId);
	void deleteByIdAndSellerId(long id,long userId);
}
