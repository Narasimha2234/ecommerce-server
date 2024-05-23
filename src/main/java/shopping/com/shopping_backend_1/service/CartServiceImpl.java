package shopping.com.shopping_backend_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping.com.shopping_backend_1.dto.AddToCartDto;
import shopping.com.shopping_backend_1.dto.CartDetailDTO;
import shopping.com.shopping_backend_1.entity.*;
import shopping.com.shopping_backend_1.repository.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl {
    @Autowired
    private CartHeaderRepository cartHeaderRepository;

    @Autowired
    private CartDetailsREpository cartDetailRepository;

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    @Transactional
    
    public CartHeader addItemToCart(Long customerId, Long productId, Integer quantity) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<CartHeader> optionalCartHeader = cartHeaderRepository.findByCustomer_Id(customerId);
        CartHeader cartHeader = optionalCartHeader.orElseGet(() -> {
            CartHeader newCartHeader = new CartHeader();
            newCartHeader.setCustomer(customer);
            return newCartHeader;
        });

        Optional<CartDetails> optionalCartDetail = cartHeader.getCartDetails().stream()
                .filter(detail -> detail.getProduct().getId() == productId)
                .findFirst();

        CartDetails cartDetail;
        if (optionalCartDetail.isPresent()) {
            cartDetail = optionalCartDetail.get();
            cartDetail.setQuantity(cartDetail.getQuantity() + quantity);
        } else {
            cartDetail = new CartDetails();
            cartDetail.setProduct(product);
            cartDetail.setQuantity(quantity);
            cartDetail.setCartHeader(cartHeader);
            cartHeader.getCartDetails().add(cartDetail);
        }

        cartHeader.setCartTotal(cartHeader.getCartDetails().stream()
                .map(CartDetails::getProductTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        return cartHeaderRepository.save(cartHeader);
    }

    @Transactional
 
    public CartHeader updateItemQuantity(Long cartId, Long productId, Integer quantity) {
        CartHeader cartHeader = cartHeaderRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartDetails cartDetail = cartHeader.getCartDetails().stream()
                .filter(detail -> detail.getProduct().getId()==(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found in cart"));

        cartDetail.setQuantity(quantity);
        cartHeader.setCartTotal(cartHeader.getCartDetails().stream()
                .map(CartDetails::getProductTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        return cartHeaderRepository.save(cartHeader);
    }
    @Transactional
   
    public AddToCartDto getCartByCustomerId(Long customerId) {
        CartHeader cartHeader = cartHeaderRepository.findByCustomer_Id(customerId)
                .orElseThrow(() -> new RuntimeException("Cart not found for customer"));

        List<CartDetailDTO> cartDetails = cartDetailRepository.findCartDetailsByCartId(cartHeader.getCartId());

        AddToCartDto cartDTO = new AddToCartDto();
        cartDTO.setCartId(cartHeader.getCartId());
        cartDTO.setCustomerId(cartHeader.getCustomer().getId());
        cartDTO.setCartTotal(cartHeader.getCartTotal());
        cartDTO.setCartDetails(cartDetails);

        return cartDTO;
    }
   
    
    public List<CartDetailDTO> getCartDetailsByCartId(Long cartId) {
        return cartDetailRepository.findCartDetailsByCartId(cartId);
    }
    @Transactional
    
    public void deleteCartItem(Long cartDetailId) {
        cartDetailRepository.deleteById(cartDetailId);;
    }
}

