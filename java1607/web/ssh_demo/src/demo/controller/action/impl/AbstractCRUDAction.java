package demo.controller.action.impl;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;

import demo.controller.action.CRUDAction;
import demo.controller.service.CRUDService;
import demo.controller.service.impl.AbstractCRUDService;
import demo.model.vo.ValueObject;

public class AbstractCRUDAction<T extends ValueObject> implements CRUDAction<T> {

	private CRUDService<T> mService;
	private T mModel;

	public AbstractCRUDAction(Class<T> voClass) {
		super();

		try {
			mModel = voClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		this.mService = new AbstractCRUDService<T>(voClass);
	}

	@Override
	public T getModel() {
		return mModel;
	}

	@Override
	public Collection<T> getModels() {
		return mService.findAll();
	}

	public String input() {
		mModel = mService.find(mModel.getId());
		return INPUT_PAGE;
	}

	public String edit() {
		mModel = mService.find(mModel.getId());
		return EDIT_PAGE;
	}
	
	public String index() {
		return MODELS_PAGE;
	}

	public String get() {
		System.out.println("GET : " + mModel);
		mModel = mService.find(mModel.getId());
		return MODEL_PAGE;
	}

	public String put() {
		System.out.println("PUT : " + mModel);
		mService.update(mModel);
		return MODELS_PAGE;
	}

	public String post() {
		System.out.println("POST : " + mModel);
		mService.add(mModel);
		return MODELS_PAGE;
	}

	public String delete() {
		System.out.println("DELETE : " + mModel);
		mService.delete(mModel);
		return MODELS_PAGE;
	}

	@Override
	public String execute() {
		System.out.println(ServletActionContext.getRequest().getMethod());
		return MODELS_PAGE;
	}

}
