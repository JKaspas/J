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
	CustomerRepository repository;

	@Test
	public void test() {
		Customer customer = new Customer();
		final String firstName = "Vardenis";
		final String lastName = "Pavardenis";
		final String email = "vardenis@pavardenis.com";

		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);

		repository.save(customer);
		Customer dbCustomer = repository.findOne(customer.getId());
		System.out.println(dbCustomer.toString());
		assertNotNull(dbCustomer);
		assertEquals(firstName, dbCustomer.getFirstName());

	}
	@Test
	public void insertTest() {
		Customer customer = new Customer();
		final String firstName = "Vardenis";
		Cart cart = new Cart();
		customer.setCart(cart);
		customer.setFirstName(firstName);

		repository.save(customer);
		Customer dbCustomer = repository.findOne(customer.getId());
		assertNotNull(dbCustomer);
		assertNotNull(dbCustomer.getCart());
		System.out.println(dbCustomer.getId());
		System.out.println(cart.getCartOwnerId());
		System.out.println(cart.getId());
		System.out.println(dbCustomer.getCart());
		
	}
}
