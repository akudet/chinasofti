package team4.proj2.model.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team4.proj2.config.AppConfig;
import team4.proj2.model.dao.prod.ProductDAO;
import team4.proj2.model.dao.prod.SellerDAO;
import team4.proj2.model.dao.prod.StockInfoDAO;
import team4.proj2.model.vo.prod.Product;
import team4.proj2.model.vo.prod.Seller;
import team4.proj2.model.vo.prod.StockInfo;

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
		System.out.println(pd.discountProducts(""));
	}

	public void insertAll(List<Product> prods) {
		for (Product prod : prods) {
			pd.insert(prod);
		}
		Seller seller = new Seller();
		seller.setName("IBM");
		StockInfo si = new  StockInfo();
		seller = sd.find(sd.insert(seller));
		si.setSeller(seller);
		si.setProduct(pd.findAll().get(0));
		si.setDiscount(0.3f);
		si.setStock(1000);
		si.setPrice(10f);
		sid.insert(si);
	}

	@Before
	public void setup() {
		deleteAll();
		insertAll(getSampleData());
	}

	public void deleteAll() {
		List<Product> prods = pd.findAll();
		for (Product prod : prods) {
			pd.delete(prod);
		}
	}

	public Product newInstance(String name, String type, String date, long sells) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Product p;
		p = new Product();
		p.setName(name);
		try {
			p.setOnSaleTime(df.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setSells(sells);
		p.setType(type);

		return p;
	}

	public List<Product> getSampleData() {
		List<Product> prods = new ArrayList<Product>(8);

		prods.add(newInstance("自在独行:贾平凹的独行世界", "书", "2016-06-01", 700));
		prods.add(newInstance("岛上书店", "书", "2015-05-12", 1000));
		prods.add(newInstance("无声告白", "书", "2016-07-01", 1033));
		prods.add(newInstance("白夜行:东野圭吾作品", "书", "2013-01-17", 1990));

		return prods;
	}

	@Test
	public void latestProductsTest() {
		List<Product> prods = pd.latestProducts("书");

		assertTrue(prods.size() > 0);
		Date onSaleTime = prods.get(0).getOnSaleTime();
		for (Product prod : prods) {
			assertEquals(prod.getType(), ("书"));
			assertTrue(onSaleTime.compareTo(prod.getOnSaleTime()) >= 0);
			onSaleTime = prod.getOnSaleTime();
		}
	}

	@Test
	public void test() {
		int size = pd.findAll().size();

		Product p = new Product();
		p.setName("hihi");

		pd.insert(p);
		assertEquals(pd.findAll().size(), size + 1);

		pd.delete(p);
		assertEquals(pd.findAll().size(), size);

	}

}
