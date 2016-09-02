package jtwu.controller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookiesService {

	Map<String, Cookie> cookies;

	public CookiesService(Cookie[] cookies) {
		super();
		this.cookies = new HashMap<String, Cookie>();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				this.cookies.put(cookie.getName(), cookie);
			}
		}
	}

	public boolean isCachedUser() {
		return cookies.containsKey("cachedUser");
	}

	public void grantUser(int expiry) {
		Cookie cookie = new Cookie("cachedUser", "true");
		cookie.setMaxAge(expiry);
		cookies.put("cachedUser", cookie);
	}
	
	public void invalidUser() {
		if (cookies.containsKey("cachedUser")) {
			Cookie cookie = cookies.get("cachedUser");
			cookie.setMaxAge(0);
		}
	}

	public void addCookiesToResponse(HttpServletResponse response) {
		for (Entry<String, Cookie> entry : cookies.entrySet()) {
			response.addCookie(entry.getValue());
		}
	}
	
}
