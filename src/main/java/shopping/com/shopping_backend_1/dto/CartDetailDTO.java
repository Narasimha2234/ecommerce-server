package shopping.com.shopping_backend_1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CartDetailDTO {
    private Long cartDetailId;
    private Long productId;
    private String productName;
    private byte[] productImage;
    private Double productPrice;
    private Integer quantity;

    public CartDetailDTO(Long cartDetailId, Long productId, String productName, byte[] productImage, Double productPrice, Integer quantity) {
        this.cartDetailId = cartDetailId;
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    // Getters and setters
}
