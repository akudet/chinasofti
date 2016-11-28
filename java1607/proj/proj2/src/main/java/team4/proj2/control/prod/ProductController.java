package team4.proj2.control.prod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import team4.proj2.control.BasicController;
import team4.proj2.model.dao.prod.ProductDAO;
import team4.proj2.model.vo.prod.Product;

@Controller
@RequestMapping(path={"/prod"})
public class ProductController extends BasicController<Product> {
	
	@Autowired
	public ProductController(ProductDAO pd) {
		submodule("prod");
	}

}
