package lt.vtvpmc.ems.akademijaIT.jk.shop.cart;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lt.vtvpmc.ems.akademijaIT.jk.shop.product.Product;

@Entity
public class Cart {

	@Id
	@GenericGenerator(name = "genCust", strategy = "increment")
	@GeneratedValue(generator = "genCust")
	@Column(name = "cart_id")
	private Integer id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PC", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "cart_id"), inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "product_id"))
	@JsonIgnore
	public List<Product> products = new ArrayList<>();

	public Cart() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduct(Product product) {
		this.products.remove(product);
	}

}
