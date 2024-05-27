package shopping.com.shopping_backend_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shopping.com.shopping_backend_2.dto.AddToCartDto;
import shopping.com.shopping_backend_2.dto.CartDetailDTO;
import shopping.com.shopping_backend_2.entity.CartDetails;
import shopping.com.shopping_backend_2.entity.CartHeader;
import shopping.com.shopping_backend_2.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @PostMapping("/add")
    public CartHeader addItemToCart(@RequestBody AddToCartDto cartdto) {
    	System.out.println(cartdto.getUserId());
        return cartService.addItemToCart(cartdto.getUserId(), cartdto.getProductId(), cartdto.getQuantity());
    }

    @PutMapping("/update")
    public CartHeader updateItemQuantity(@RequestBody AddToCartDto addToCartDto) {
        return cartService.updateItemQuantity(addToCartDto.getCartId(), addToCartDto.getProductId(), addToCartDto.getQuantity());
    }
    @GetMapping("/{customerId}")
    public AddToCartDto getCart(@PathVariable Long customerId) {
        return cartService.getCartByCustomerId(customerId);
    }

    @GetMapping("/details/{cartId}")
    public List<CartDetailDTO> getCartDetails(@PathVariable Long cartId) {
        return cartService.getCartDetailsByCartId(cartId);
    }
    @DeleteMapping("/delete/{cartDetailId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable Long cartDetailId) {
        try {
            cartService.deleteCartItem(cartDetailId);
            return ResponseEntity.ok("Cart item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting cart item");
        }
    }
}
