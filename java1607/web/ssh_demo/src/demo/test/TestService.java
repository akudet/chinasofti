package demo.test;

import java.util.List;

public class TestService {
	
	private TestDAO dao;
	
	private List<String> list;

	public void setList(List<String> list) {
		this.list = list;
	}
	
	public List<String> getList() {
		return list;
	}

	public TestService() {
		super();
	}

	public void setDao(TestDAO dao) {
		this.dao = dao;
	}

	public String test() {
		return dao.test();
	}

	public TestService(TestDAO dao) {
		super();
		this.dao = dao;
	}
	
	

}
