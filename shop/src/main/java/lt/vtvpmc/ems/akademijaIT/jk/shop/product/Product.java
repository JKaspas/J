package lt.vtvpmc.ems.akademijaIT.jk.shop.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lt.vtvpmc.ems.akademijaIT.jk.shop.cart.Cart;

@Entity
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Integer id;
	private String name;
	private String description;
	private String imageUrl;
	private Double price;
	private Integer quantity;
	@ManyToOne
	private ProductType type; 

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	@ManyToMany(mappedBy = "products")
	private List<Cart> carts = new ArrayList<>();

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Product() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
