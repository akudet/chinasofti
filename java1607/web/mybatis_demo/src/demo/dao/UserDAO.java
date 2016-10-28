package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import demo.vo.Message;

public interface UserDAO {

	@Select("select * from message")
	public List<Message> findAll();

}
