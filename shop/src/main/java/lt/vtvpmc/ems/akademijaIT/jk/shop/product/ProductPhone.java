package lt.vtvpmc.ems.akademijaIT.jk.shop.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Phone")
public class ProductPhone extends Product {
	private String image;

	public ProductPhone() {
		super();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
