package shopping.com.shopping_backend_1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import shopping.com.shopping_backend_1.dto.CartDetailDTO;
import shopping.com.shopping_backend_1.entity.CartDetails;

import java.util.List;

public interface CartDetailsREpository extends CrudRepository<CartDetails, Long> {
    @Query("SELECT new shopping.com.shopping_backend_1.dto.CartDetailDTO(" +
            "cd.cartDetailId, p.id, p.productname, p.image, p.price, cd.quantity) " +
            "FROM CartDetails cd " +
            "JOIN cd.product p " +
            "WHERE cd.cartHeader.cartId = :cartId")
    List<CartDetailDTO> findCartDetailsByCartId(Long cartId);
}
