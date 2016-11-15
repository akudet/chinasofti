package demo;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import demo.dao.MessageDAO;
import demo.vo.Book;
import demo.vo.Message;

public class Test {
	
	private static SqlSessionFactory ssf;
	
	static {
		try {
			ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("ibatis-config.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SqlSession ss = ssf.openSession();
		
		MessageDAO md = ss.getMapper(MessageDAO.class);
		
		System.out.println(md.findOne(1));
		System.out.println(md.findOneMapped(1));
		
		for (Book book : md.findAllBooks()) {
			System.out.println(book);
		}
		
		
	}

}
