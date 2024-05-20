package shopping.com.shopping_backend_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.com.shopping_backend_1.entity.CustomerAddress;
import shopping.com.shopping_backend_1.repository.CustomerAddressRepository;
@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	@Override
	public List<CustomerAddress> getAllAddresses() {
		
		return customerAddressRepository.findAll();
	}

	@Override
	public CustomerAddress addNewAddress(CustomerAddress customerAddress) {
		
		return customerAddressRepository.save(customerAddress);
	}

	@Override
	public CustomerAddress updateAddress(long id, CustomerAddress customerAddress) {
		CustomerAddress cuAddress = customerAddressRepository.findById(id).get();
		CustomerAddress updatedAddress = customerAddressRepository.save(cuAddress);
		return updatedAddress;
	}

	@Override
	public void deleteAddress(long id) {
		customerAddressRepository.deleteById(id);
		
	}

}
