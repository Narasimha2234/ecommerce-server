package shopping.com.shopping_backend_1.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddToCartDto {
	 	private long cartId;
	 	private Long customerId;
	    private Long productId;
	    private Integer quantity;
	    private BigDecimal cartTotal;
	    private List<CartDetailDTO> cartDetails;
}
