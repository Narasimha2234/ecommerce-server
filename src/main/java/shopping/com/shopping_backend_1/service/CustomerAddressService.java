package shopping.com.shopping_backend_1.service;

import java.util.List;

import shopping.com.shopping_backend_1.entity.CustomerAddress;



public interface CustomerAddressService {
	List<CustomerAddress> getAllAddresses();
	CustomerAddress addNewAddress(CustomerAddress customerAddress);
	CustomerAddress updateAddress(long id,CustomerAddress customerAddress);
	void deleteAddress(long id);
}
