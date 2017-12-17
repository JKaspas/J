package lt.vtvpmc.ems.akademijaIT.jk.shop.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.vtvpmc.ems.akademijaIT.jk.shop.product.Product;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
	@Autowired
	CartService service;

	@GetMapping(value = "/{customerId}/")
	List<Product> getCartItemList(@PathVariable("customerId") Integer cId) {
		return service.getCartItemList(cId);
	}

	@PostMapping(value = "/{customerId}/{productId}/")
	void addProductToCart(@PathVariable("customerId") Integer cId, @PathVariable("productId") Integer pId) {
		service.addProductToCart(cId, pId);
	}
}
