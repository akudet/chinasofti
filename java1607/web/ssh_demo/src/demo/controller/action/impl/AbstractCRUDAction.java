package demo.controller.action.impl;

import com.opensymphony.xwork2.ModelDriven;

import demo.controller.action.CRUDAction;
import demo.controller.service.CRUDService;
import demo.controller.service.impl.AbstractCRUDService;

public class AbstractCRUDAction<T> implements CRUDAction<T>, ModelDriven<T> {
	// this should use annotation
	private final String INPUT_PAGE = "input";
	private final String EDIT_PAGE = "edit";
	private final String INDEX_PAGE = "index";
	
	private final String MODEL_PAGE = "model";

	private CRUDService<T> service;
	private Class<T> voClass;
	private T model;

	public AbstractCRUDAction(Class<T> voClass) {
		super();
		this.voClass = voClass;
		this.service = new AbstractCRUDService<T>(voClass);
	}
	
	@Override
	public T getModel() {
		try {
			return voClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String input() {
		return INPUT_PAGE;
	}

	@Override
	public String edit() {
		return EDIT_PAGE;
	}

	@Override
	public String index() {
		return INDEX_PAGE;
	}

	@Override
	public String get() {
		return MODEL_PAGE;
	}

	@Override
	public String put() {
		service.update(model);
		return index();
	}

	@Override
	public String post() {
		service.create(model);
		return index();
	}

	@Override
	public String delete() {
		service.delete(model);
		return index();
	}

}
