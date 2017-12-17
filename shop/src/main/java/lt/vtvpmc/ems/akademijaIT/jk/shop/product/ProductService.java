package lt.vtvpmc.ems.akademijaIT.jk.shop.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getProductById(Integer productId) {
		return repo.findOne(productId);
	}

	public void addNewProduct(Product product) {
		System.out.println("type of product:"+product.getType().getName());
		repo.save(product);
	}

	public void deleteProduct(Integer id) {
		repo.delete(id);
	}

}