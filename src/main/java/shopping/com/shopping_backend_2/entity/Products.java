package shopping.com.shopping_backend_2.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
	private String description;
	private int quantity;
	private double price;
	
	@ManyToOne()
	@JoinColumn(name="seller_id")
	private User seller;
}

