package shopping.com.shopping_backend_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopping.com.shopping_backend_1.dto.ProductDto;
import shopping.com.shopping_backend_1.entity.Products;
import shopping.com.shopping_backend_1.service.ProductsService;


@RequestMapping("/products")
@RestController
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	@GetMapping("/getallproducts")
	public List<Products>  getAllProducts() {
		return productsService.getAllProducts();
	}
	
	@GetMapping("/getproducts/{id}")
	public List<Products> getProducts(@PathVariable long id) {
		
		return productsService.getProductsBySeller(id);
	}
	

	@PostMapping("/saveProduct/{id}")
	public Products saveProduct(@ModelAttribute ProductDto productDto , @PathVariable Long id) {
	return	productsService.saveProduct(productDto, id);
	}
	@PutMapping("/updateProduct/{sellerid}/{productid}")
	public Products updateProduct(@ModelAttribute ProductDto productDto , @PathVariable Long sellerid,@PathVariable long productid) {
	return	productsService.updateProduct(productDto, sellerid,productid);
	}
	
	@GetMapping("/get/{category}")
	public List<Products> getByCategory(@PathVariable String category){
		return productsService.getByCategory(category);
	}
	@DeleteMapping("/deleteProduct/{sellerId}/{productId}")
	public void deleteProduct(@PathVariable long sellerId,@PathVariable long productId) {
		productsService.deleteProduct(sellerId, productId);
	}
}
