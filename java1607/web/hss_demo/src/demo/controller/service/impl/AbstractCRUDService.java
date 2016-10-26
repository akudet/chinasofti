package demo.controller.service.impl;

import demo.controller.service.CRUDService;
import demo.model.dao.abst.AbstractDAO;

public class AbstractCRUDService<T> extends AbstractDAO<T> implements CRUDService<T> {

	public AbstractCRUDService(Class<T> voClass) {
		super(voClass);
	}
}
