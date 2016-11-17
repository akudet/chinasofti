package team4.proj1.service.include.security;

import team4.proj1.model.vo.admin.User;

public interface AuthenticationService {
	
	public static final int ADMIN_ACCESS = 0;
	public static final int OP_ACESS = 1;

	public User login(String username, String userpass);

	public boolean accept(String userId, int access);
	
}
