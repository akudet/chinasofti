package demo.controller.service.impl;

import java.io.Serializable;
import java.util.List;

import demo.controller.service.CRUDService;
import demo.model.dao.DAO;
import demo.model.dao.abst.AbstractDAO;

public class AbstractCRUDService<T> implements CRUDService<T> {
	
	private DAO<T> mDAO;
	
	public void init(DAO<T> dao) {
		mDAO = dao;
	}
	
	@Override
	public Serializable add(T t) {
		return mDAO.add(t);
	}

	@Override
	public void delete(T t) {
		mDAO.delete(t);
	}

	@Override
	public T find(Serializable id) {
		return mDAO.find(id);
	}

	@Override
	public List<T> findAll() {
		return mDAO.findAll();
	}

	@Override
	public void update(T t) {
		mDAO.update(t);
	}
}
