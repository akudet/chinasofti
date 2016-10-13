package demo.controller.service.impl;

import demo.controller.service.CRUDService;
import demo.model.dao.impl.AbstractDAO;

public class AbstractCRUDService<T> extends AbstractDAO<T> implements CRUDService<T> {

	public AbstractCRUDService(Class<T> voClass) {
		super(voClass);
	}
}
