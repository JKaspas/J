package lt.vtvpmc.ems.akademijaIT.jk.shop.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping(value = "/")
	List<Customer> listAllCustomers() {
		return service.getCustomers();
	}

	@PostMapping(value = "/")
	void createCustomer(@RequestBody Customer cust) {
		service.saveCustomer(cust);
	}

	@PutMapping(value = "/{id}")
	void getOther(@RequestBody Customer customer, @PathVariable("id") Integer id) {
		service.updateCustomer(customer, id);
	}
	
	@DeleteMapping(value = "/{id}")
	void removeCustomer(@PathVariable("id") Integer id) {
		service.deleteCustomer(id);
	}
}
