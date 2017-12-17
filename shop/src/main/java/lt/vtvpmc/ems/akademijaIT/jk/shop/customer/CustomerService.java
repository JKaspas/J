package lt.vtvpmc.ems.akademijaIT.jk.shop.customer;

import java.util.List;

import javax.transaction.Transactional;

import org.hamcrest.CustomTypeSafeMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	void saveCustomer(Customer customer) {
		repo.save(customer);
	}

	List<Customer> getCustomers() {
		return (List<Customer>) repo.findAll();
	}
	
	void deleteCustomer(Integer id) {
		repo.delete(id);
	}

	public void updateCustomer(Customer customer, Integer id) {
		customer.setId(id);
		repo.save(customer);
	}

}