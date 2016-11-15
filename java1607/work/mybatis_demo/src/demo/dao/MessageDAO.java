package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import demo.vo.Book;
import demo.vo.Message;

public interface MessageDAO {
	
//	@Select("select * from message where id = #{id}")
	public Message findOne(int id);
	
	public Message findOneMapped(int id);
	
	public List<Book> findAllBooks();

}
