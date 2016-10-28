package demo.dao;

import org.apache.ibatis.annotations.Select;

import demo.vo.Message;

public interface MessageDAO {
	
//	@Select("select * from message where id = #{id}")
	public Message findOne(int id);
	
	public Message findOneMapped(int id);

}
