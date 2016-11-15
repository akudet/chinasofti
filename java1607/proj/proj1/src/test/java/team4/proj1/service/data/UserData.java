package team4.proj1.service.data;

import team4.proj1.service.UserService;

public class UserData extends Data {
	private UserService service = new UserService();

	public void addData() {
		service.add("马厦伟", "123", 1);
	}
}
