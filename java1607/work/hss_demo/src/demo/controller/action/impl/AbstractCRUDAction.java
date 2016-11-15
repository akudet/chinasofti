package demo.controller.action.impl;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import demo.controller.action.CRUDAction;
import demo.controller.service.CRUDService;
import demo.controller.service.impl.AbstractCRUDService;
import demo.model.vo.ValueObject;

public class AbstractCRUDAction<T extends ValueObject> implements CRUDAction<T> {

	private CRUDService<T> mService;
	private T mModel;
	
	public void init(T model, CRUDService<T> service) {
		mModel = model;
		mService = service;
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
		return NEW_PAGE;
	}

	public String edit() {
		mModel = mService.find(mModel.getId());
		return EDIT_PAGE;
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
		HttpServletRequest req = ServletActionContext.getRequest();
		String method = req.getMethod();
		
		System.out.println(method + " : " + req.getRequestURI());
		String uri = req.getRequestURI();
		
		// match user/:id.action where id is pure number to get a model who's id is :id
		String model = mModel.getClass().getSimpleName().toLowerCase();
		Matcher maId = Pattern.compile("^.*" + model + "/([\\d]+).*").matcher(uri);
		if (maId.matches()) {
			String id = maId.group(1);
			mModel.setId(Integer.parseInt(id));
			return get();
		}
		
		// dispatch by action
		// TODO : improve this logic
		if (uri.endsWith("get.action")) {
			return get();
		}
		
		if (uri.endsWith("post.action")) {
			return post();
		}
		
		if (uri.endsWith("put.action")) {
			return put();
		}
		
		if (uri.endsWith("delete.action")) {
			return delete();
		}
		
		if (uri.endsWith("edit.action")) {
			return edit();
		}
		
		if (uri.endsWith("new.action")) {
			return input();
		}
		
		// dispatch by methods compatibility issues
		if (method.equals("GET")) {
			if (null != req.getParameter("id")) {
				return get();
			}
		} else if (method.equals("POST")) {
			return post();
		} else if (method.equals("PUT")) {
			return put();
		} else if (method.equals("DELETE")) {
			return delete();
		}
		
		return MODELS_PAGE;
	}

}
