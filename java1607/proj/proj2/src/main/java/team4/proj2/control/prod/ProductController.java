package team4.proj2.control.prod;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import team4.proj2.control.BasicController;
import team4.proj2.model.dao.prod.ProductDAO;
import team4.proj2.model.vo.prod.Product;

@Controller
@RequestMapping(path = { "/prod" })
public class ProductController extends BasicController<Product> {

	@Autowired
	public ProductController(ProductDAO pd) {
		submodule("prod");
	}

	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest req,
			@RequestParam MultipartFile file) throws IllegalStateException, IOException {

		File dest = new File(req.getServletContext().getRealPath("/files")
				+ "/" + file.getOriginalFilename());
		dest.mkdirs();
		System.out.println(dest);
		System.out.println(file);
		file.transferTo(dest);

		return index(req);
	}

}
