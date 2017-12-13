package lt.vtvpmc.ems.akademijaIT.jk.shop.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	String getHello() {
		return "Aloha world!";
	}

	void postCustomer(Customer cust) {
		repo.save(cust);
	}

	List<Customer> getCustomers() {
		return (List<Customer>) repo.findAll();
	}

}
