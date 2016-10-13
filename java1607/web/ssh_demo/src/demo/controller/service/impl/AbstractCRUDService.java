package demo.controller.service.impl;

import demo.controller.service.CRUDService;
import demo.model.dao.Dao;
import demo.model.dao.impl.AbstractDao;

public class AbstractCRUDService<T> implements CRUDService<T> {
	
	private Dao<T> dao;

	public AbstractCRUDService(Class<T> voClass) {
		super();
		this.dao = new AbstractDao<T>(voClass);
	}

	@Override
	public void create(T t) {
		dao.add(t);
	}

	@Override
	public T read(int id) {
		return dao.find(id);
	}

	@Override
	public void update(T t) {
		dao.update(t);;
	}

	@Override
	public void delete(T t) {
		dao.delete(t);;
	}
	
}
