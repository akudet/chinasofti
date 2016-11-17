package team4.proj1.service.data;

import team4.proj1.service.impl.admin.UserServiceImpl;

public class UserData extends Data {
	private UserServiceImpl service = new UserServiceImpl();

	public void addData() {
		service.add("马厦伟", "123", 1);
	}
}
