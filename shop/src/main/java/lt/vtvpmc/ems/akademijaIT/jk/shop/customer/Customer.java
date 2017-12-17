package lt.vtvpmc.ems.akademijaIT.jk.shop.customer;

import javax.persistence.*;

import lt.vtvpmc.ems.akademijaIT.jk.shop.cart.Cart;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return cart != null
				? "id:" + this.id + "\tfirstName:" + this.firstName + "\tlastName:" + this.lastName + "\temail:"
						+ this.email + "\tcart:" + this.cart.getId()
				: "id:" + this.id + "\tfirstName:" + this.firstName + "\tlastName:" + this.lastName + "\temail:"
						+ this.email;
	}

}
