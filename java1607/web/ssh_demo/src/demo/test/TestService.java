package demo.test;

public class TestService {
	
	private TestDAO dao;

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
