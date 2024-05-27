package shopping.com.shopping_backend_2.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.Cacheable;
import shopping.com.shopping_backend_2.dto.ProductDto;
import shopping.com.shopping_backend_2.entity.Products;
import shopping.com.shopping_backend_2.entity.User;
import shopping.com.shopping_backend_2.repository.ProductsRepository;
import shopping.com.shopping_backend_2.repository.UserRepository;
@Service
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	@Transactional
	@CacheEvict(value = {"productsByCategory", "productsBySeller", "allProducts"}, allEntries = true)
	public void deleteProduct(long userId,long productId) {
		// TODO Auto-generated method stub
		productsRepository.deleteByIdAndSellerId(productId, userId);
	}

	@Override
	 @CacheEvict(value = {"productsByCategory", "productsBySeller", "allProducts"}, allEntries = true)
	public Products updateProduct(ProductDto productDto, Long userId, long productId) {
	    Products existingProduct = productsRepository.findByIdAndSellerId(productId, userId);

	    if (existingProduct == null) {
	        throw new RuntimeException("Product not found");
	    }

	    // Update fields only if they are not null or empty
	    if (productDto.getBrandname() != null && !productDto.getBrandname().isEmpty()) {
	        existingProduct.setBrandname(productDto.getBrandname());
	    }
	    if (productDto.getCategory() != null && !productDto.getCategory().isEmpty()) {
	        existingProduct.setCategory(productDto.getCategory());
	    }
	    if (productDto.getDescription() != null && !productDto.getDescription().isEmpty()) {
	        existingProduct.setDescription(productDto.getDescription());
	    }
	    if ( productDto.getPrice() != 0.0) {
	        existingProduct.setPrice(productDto.getPrice());
	    }
	    if (productDto.getProductname() != null && !productDto.getProductname().isEmpty()) {
	        existingProduct.setProductname(productDto.getProductname());
	    }
	    if (productDto.getQuantity() != 0) {
	        existingProduct.setQuantity(productDto.getQuantity());
	    }
	    if (productDto.getStatus() != null && !productDto.getStatus().isEmpty()) {
	        existingProduct.setStatus(productDto.getStatus());
	    }

	    // Handle image update if a new image is provided
	    if (productDto.getImage() != null && !productDto.getImage().isEmpty()) {
	        try {
	            existingProduct.setImage(productDto.getImage().getBytes());
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to update image", e);
	        }
	    }

	    return productsRepository.save(existingProduct);
	}


	@Override
	 @CacheEvict(value = {"productsByCategory", "productsBySeller", "allProducts"}, allEntries = true)
	 public Products saveProduct(ProductDto productDto, Long userId) {
     User user=  userRepository.findById(userId).get();
	   Products product=new Products();
       product.setBrandname(productDto.getBrandname());
       product.setCategory(productDto.getCategory());
       product.setDescription(productDto.getDescription());
       try {
		product.setImage(productDto.getImage().getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       product.setPrice(productDto.getPrice());
       product.setProductname(productDto.getProductname());
       product.setQuantity(productDto.getQuantity());
       product.setStatus(productDto.getStatus());
       product.setSeller(user);
      return productsRepository.save(product);
    }

	@Override
	 @org.springframework.cache.annotation.Cacheable(value = "productsBySeller", key = "#id")
	public List<Products> getProductsBySeller(long id) {
		
		return productsRepository.findBySellerId(id);
	}

	@Override
	@org.springframework.cache.annotation.Cacheable(value = "allProducts")
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	


}
