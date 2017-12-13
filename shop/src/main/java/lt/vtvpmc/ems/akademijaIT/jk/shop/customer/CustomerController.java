package lt.vtvpmc.ems.akademijaIT.jk.shop.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping(value = "/")
	String getHello() {
		return service.getHello();
	}
	
	@PostMapping(value="/")
	void createCustomer(@RequestBody Customer cust) {
		service.postCustomer(cust);
	}
	
	@GetMapping(value = "/tst")
	List<Customer> getOther() {
		return service.getCustomers();
	}
}
