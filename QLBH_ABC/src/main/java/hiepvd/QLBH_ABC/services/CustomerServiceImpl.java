package hiepvd.QLBH_ABC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hiepvd.QLBH_ABC.models.Customer;
import hiepvd.QLBH_ABC.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerByID(int id) {
		Optional<Customer> opt =customerRepository.findById( id);
		if (opt.isPresent()) //tìm thấy
			return opt.get(); 
		else 
			return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
}
