package shopping.com.shopping_backend_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import shopping.com.shopping_backend_1.dto.ProductDto;
import shopping.com.shopping_backend_1.entity.Products;


public interface ProductsService {
	List<Products> getProductsBySeller(long id);
	List<Products>getAllProducts();
	void deleteProduct(long sellerId,long ProductId);
	Products updateProduct(ProductDto productDto, Long sellerId,long productId);
	Products saveProduct(ProductDto productDto, Long userId);
}
