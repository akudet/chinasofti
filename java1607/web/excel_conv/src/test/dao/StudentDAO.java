package test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import test.vo.Student;

public interface StudentDAO {
	
	public List<Student> findAll();

}
