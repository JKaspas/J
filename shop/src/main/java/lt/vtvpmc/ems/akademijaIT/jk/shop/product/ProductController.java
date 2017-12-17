package lt.vtvpmc.ems.akademijaIT.jk.shop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping(value = "")
	private List<Product> getAll() {
		return service.getAllProducts();
	}

	@GetMapping(value = "/{id}")
	private Product getOneProductById(@PathVariable("id") Integer id) {
		return service.getProductById(id);
	}

	@PutMapping(value = "/{id}")
	void editProduct(@RequestBody Product product, @PathVariable("id") Integer id) {
		product.setId(id);
		service.addNewProduct(product);
	}

	@PostMapping(value = "/new")
	void addNewProduct(@RequestBody Product product) {
		service.addNewProduct(product);
	}

	@DeleteMapping(value = "/{id}")
	void deleteProduct(@PathVariable("id") Integer id) {
		service.deleteProduct(id);
	}
	@PutMapping(value = "/{id}/{typeName}")
	void editProductType(@PathVariable("id") Integer id,@PathVariable("typeName") ProductType type) {
		Product product = service.getProductById(id);
		product.setType(type);
		service.addNewProduct(product);
	}
}
