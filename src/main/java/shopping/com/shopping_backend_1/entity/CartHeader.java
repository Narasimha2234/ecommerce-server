package shopping.com.shopping_backend_1.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class CartHeader {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long cartId;

	    @ManyToOne
	    @JoinColumn(name = "customer_id", nullable = false)
	    private Customer customer;

	    private BigDecimal cartTotal = BigDecimal.ZERO;

	    @OneToMany(mappedBy = "cartHeader", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<CartDetails> cartDetails = new ArrayList<>();
	    
	    public void addCartDetail(CartDetails cartDetail) {
	        cartDetails.add(cartDetail);
	        cartDetail.setCartHeader(this);
	    }
}
