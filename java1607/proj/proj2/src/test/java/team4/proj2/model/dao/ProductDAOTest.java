package team4.proj2.model.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team4.proj2.model.vo.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class ProductDAOTest {
	
	@Resource
	private ProductDAO pd;

	@Test
	public void test() {
		Product p = new Product();
		p.setName("hihi");
		p.setVersion(1);;
		pd.add(p);
		System.out.println(pd.findAll());
	}

}
