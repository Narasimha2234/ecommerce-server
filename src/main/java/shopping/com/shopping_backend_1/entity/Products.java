package shopping.com.shopping_backend_1.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;  
	private String productname;
	private String brandname;
	private String category;
	private String status;
	@Lob
    private byte[] image;
	private String description;
	private int quantity;
	private double price;
	
	@ManyToOne()
	@JoinColumn(name="seller_id")
	private Seller seller;

	@Override
	public String toString() {
		return "Products [id=" + id + ", productname=" + productname + ", brandname=" + brandname + ", category="
				+ category + ", status=" + status + ", image=" + Arrays.toString(image) + ", description=" + description
				+ ", quantity=" + quantity + ", price=" + price + ", seller=" + seller + "]";
	}

	
	

}

