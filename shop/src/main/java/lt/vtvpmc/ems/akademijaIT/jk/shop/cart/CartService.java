package lt.vtvpmc.ems.akademijaIT.jk.shop.cart;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vtvpmc.ems.akademijaIT.jk.shop.customer.Customer;
import lt.vtvpmc.ems.akademijaIT.jk.shop.customer.CustomerRepository;
import lt.vtvpmc.ems.akademijaIT.jk.shop.product.Product;
import lt.vtvpmc.ems.akademijaIT.jk.shop.product.ProductRepository;

@Service
@Transactional
public class CartService {
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private ProductRepository prodRepo;

	public List<Product> getCartItemList(Integer id) {
		if (checkCustomerId(id) && checkCustomerCartExsist(id)) {
			Integer cartId = custRepo.findOne(id).getCart().getId();
			return cartRepo.findOne(cartId).getProducts();
		} else {
			createCart(id);
			return null;
		}
	}

	public void createCart(Integer customerId) {
		try {
			Customer cust = custRepo.getOne(customerId);
			cust.setCart(new Cart());
			custRepo.save(cust);
			System.out.println("cust cart id:" + cust.getCart().getId());
		} catch (Exception e) {
			throw new IllegalArgumentException("Customer not found");
		}

	}

	public void addProductToCart(Integer customerId, Integer productId) {
		Cart cart;
		Product product;
		if (checkCustomerId(customerId)) {
			if (!checkCustomerCartExsist(customerId)) {
				createCart(customerId);
			}
		} else {
			throw new IllegalArgumentException("Customer not found");
		}
		try {
			cart = custRepo.getOne(customerId).getCart();
			product = prodRepo.getOne(productId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Product not found");
		}
		Integer availableProduct = product.getQuantity() - product.getCarts().size();
		System.out.println("quantity:"+ product.getQuantity() + "\nused:"+product.getCarts().size());
		if (availableProduct > 0) {
			cart.addProduct(product);
		} else {
			throw new IllegalStateException("Product quantity error");
		}
	}

	private boolean checkCustomerId(Integer customerId) {
		return custRepo.findOne(customerId) != null;
	}

	private boolean checkCustomerCartExsist(Integer customerId) {
		return custRepo.findOne(customerId).getCart() != null;
	}
}
