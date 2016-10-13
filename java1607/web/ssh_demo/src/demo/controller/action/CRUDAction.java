package demo.controller.action;

public interface CRUDAction<T> {

	public String input();
	public String edit();
	
	public String index();
	
	public String get();
	public String put();
	public String post();
	public String delete();
}
