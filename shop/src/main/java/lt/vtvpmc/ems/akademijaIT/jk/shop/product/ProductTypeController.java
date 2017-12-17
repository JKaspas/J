
package lt.vtvpmc.ems.akademijaIT.jk.shop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/type")
public class ProductTypeController {
	@Autowired
	ProductTypeRepository typeRepo;

	@GetMapping(value="")
	List<ProductType> getAllTypes() {
		return typeRepo.findAll();
	}

}
