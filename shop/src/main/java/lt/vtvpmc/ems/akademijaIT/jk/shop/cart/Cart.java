package lt.vtvpmc.ems.akademijaIT.jk.shop.cart;

import javax.persistence.*;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	@Column(name="cart_id")
	private Integer id;
	private Integer ownerId;
	
//  @OneToMany
//	@JoinColumn(name="product_id")
//	private List<Product> products = new ArrayList<Product>();

	public Cart() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCartOwnerId() {
		return ownerId;
	}

	public void setCartOwnerId(Integer cartOwnerId) {
		this.ownerId = cartOwnerId;
	}

//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
}
