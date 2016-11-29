package team4.proj2.model.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team4.proj2.config.AppConfig;
import team4.proj2.model.dao.prod.ProductDAO;
import team4.proj2.model.dao.prod.SellerDAO;
import team4.proj2.model.dao.prod.StockInfoDAO;
import team4.proj2.model.vo.prod.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ProductDAOTest {

	@Resource
	private ProductDAO pd;
	@Resource
	private StockInfoDAO sid;
	@Resource
	private SellerDAO sd;

	@Test
	public void stockInfoTest() {
		sid.findAll();
	}

	@Test
	public void test() {
		Product p = new Product();
		p.setName("hihi");

		pd.insert(p);
		assertEquals(pd.findAll().size(), 1);
		
	}

}
