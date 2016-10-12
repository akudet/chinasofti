package hibernate_demo.vo;

import hibernate_demo.dao.AbstractDao;

public class MyEntityDao extends AbstractDao<MyEntity>{

	public MyEntityDao() {
		super(MyEntity.class);
	}

	
	public static void main(String[] args) {
		MyEntityDao dao = new MyEntityDao();
		
		dao.add(new MyEntity());
		
		System.out.println(dao.findAll("From MyEntity"));
	}
}
