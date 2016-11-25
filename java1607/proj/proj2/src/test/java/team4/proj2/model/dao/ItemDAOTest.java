package team4.proj2.model.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import team4.proj2.model.dao.impl.hb.ItemDAOImpl;
import team4.proj2.model.dao.impl.hb.abst.db.HibernateConfig;
import team4.proj2.model.vo.Item;

public class ItemDAOTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		ItemDAOImpl id = context.getBean(ItemDAOImpl.class);
		
		Item i = new Item();
		i.setId(10);
		i.setName("212");
		
		id.add(i);
		
		System.out.println(id.findAll());
	}

}
