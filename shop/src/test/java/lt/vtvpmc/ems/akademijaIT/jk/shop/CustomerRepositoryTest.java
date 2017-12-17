package lt.vtvpmc.ems.akademijaIT.jk.shop;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lt.vtvpmc.ems.akademijaIT.jk.shop.cart.Cart;
import lt.vtvpmc.ems.akademijaIT.jk.shop.customer.Customer;
import lt.vtvpmc.ems.akademijaIT.jk.shop.customer.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Transactional
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository custRepo;

	@Test
	public void test() {
		Customer customer = new Customer();
		final String firstName = "Vardenis";
		final String lastName = "Pavardenis";
		final String email = "vardenis@pavardenis.com";

		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);

		custRepo.save(customer);
		Customer dbCustomer = custRepo.findOne(customer.getId());
		System.out.println(dbCustomer.toString());

		assertNotNull(dbCustomer);
		assertEquals(firstName, dbCustomer.getFirstName());

	}

	@Test
	public void insertTest() {
		Customer customer = new Customer();
		final String firstName = "Vardenis 2";
		Cart cart = new Cart();
		customer.setCart(cart);
		customer.setFirstName(firstName);

		Customer bla = custRepo.save(customer);
		System.out.println(bla.getCart().getId());
		
		Customer dbCustomer = custRepo.findOne(customer.getId());

		assertNotNull(dbCustomer);
		assertNotNull(dbCustomer.getCart());
		System.out.println(dbCustomer.toString());
		System.out.println(cart.getId());

	}
}
