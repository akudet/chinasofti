package demo.controller.action;

import java.util.Collection;

import com.opensymphony.xwork2.ModelDriven;

public interface CRUDAction<T> extends ModelDriven<T> {
	public final String INPUT_PAGE = "input";
	public final String EDIT_PAGE = "edit";
	
	public final String MODEL_PAGE = "model";
	public final String MODELS_PAGE = "models";
	
	public Collection<T> getModels();
	
	public String execute();
	
	public String get();
	public String post();
	public String put();
	public String delete();
}
