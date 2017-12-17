package lt.vtvpmc.ems.akademijaIT.jk.shop;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lt.vtvpmc.ems.akademijaIT.jk.shop.product.Product;
import lt.vtvpmc.ems.akademijaIT.jk.shop.product.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Transactional
public class ProductRepositoryTest {

	@Autowired
	ProductRepository repository;

	@Test
	public void insertTest() {
		Product product = new Product();
		final String name="Product name";
		final String description="Description of a product";
		final Double price=2.20d;
		final Integer quantity=20;

		product.setDescription(description);
		product.setName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
		
		repository.save(product);
		Product dbProduct = repository.findOne(product.getId());
		System.out.println(dbProduct.toString());
		assertNotNull(dbProduct);
		assertEquals(name, dbProduct.getName());
		assertEquals(description, dbProduct.getDescription());
		assertEquals(price, dbProduct.getPrice(), 0.001d);
	}

}
