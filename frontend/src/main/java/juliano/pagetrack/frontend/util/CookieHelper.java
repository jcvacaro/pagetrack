package juliano.pagetrack.frontend.util;

import java.rmi.server.UID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {

	private static final String COOKIE_NAME = "juliano.pagetrack.id";

	public Cookie createCookie() {
		Cookie c = new Cookie(COOKIE_NAME, new UID().toString());
		c.setMaxAge(Integer.MAX_VALUE);
		return c;
	}

	public Cookie getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if ((cookies != null) && (cookies.length > 0)) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().startsWith(COOKIE_NAME)) {
					return cookie;
				}
			}
		}
		return null;
	}

}
