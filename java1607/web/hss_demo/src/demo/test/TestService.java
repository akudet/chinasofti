package demo.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestService {
	
	private TestDAO dao;
	
	private List<String> list;
	private Map<String, Integer> map;
	private Set<String> set;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

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
