package shopping.com.shopping_backend_2.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CartDetails {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long cartDetailId;

	    @ManyToOne
	    @JoinColumn(name = "cart_id", nullable = false)
	    @JsonIgnore
	    private CartHeader cartHeader;

	    @ManyToOne
	    @JoinColumn(name = "product_id", nullable = false)
	    private Products product;

	    private Integer quantity = 1;

	    @Transient
	    private BigDecimal productTotal;

	    public BigDecimal getProductTotal() {
	        return product != null ? BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(quantity)) : BigDecimal.ZERO;
	    }

}
