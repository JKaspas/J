package lt.vtvpmc.ems.akademijaIT.jk.shop;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lt.vtvpmc.ems.akademijaIT.jk.shop.cart.Cart;
import lt.vtvpmc.ems.akademijaIT.jk.shop.cart.CartRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Transactional
public class CartRepositoryTest {

	@Autowired
	CartRepository repository;

	@Test
	public void insertTest() {
		Cart cart = new Cart();

		repository.save(cart);
		Cart dbCart = repository.findOne(cart.getId());
		assertNotNull(dbCart);

	}

}
