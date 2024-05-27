package shopping.com.shopping_backend_2.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProductDto {
	  
	private String productname;
	private String brandname;
	private String category;
	private String status;
	private MultipartFile image;
	private String description;
	private int quantity;
	private double price;

}
