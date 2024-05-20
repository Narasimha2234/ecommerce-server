package shopping.com.shopping_backend_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.com.shopping_backend_1.entity.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {

}
