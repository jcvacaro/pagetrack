package juliano.pagetrack.frontend.util;

import java.rmi.server.UID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieHelper {

	private static final Logger logger = LoggerFactory.getLogger(CookieHelper.class);
	private static final String COOKIE_NAME = "juliano.pagetrack.id";

	public Cookie createCookie() {
		logger.info("createCookie invoked");
		Cookie c = new Cookie(COOKIE_NAME, new UID().toString());
		c.setMaxAge(Integer.MAX_VALUE);
		return c;
	}

	public Cookie getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if ((cookies != null) && (cookies.length > 0)) {
			logger.info("cookies found in the request: cookies=" + cookies.length);
			for (Cookie cookie : cookies) {
				if (cookie.getName().startsWith(COOKIE_NAME)) {
					logger.info("application cookie found in the request: cookie=" + cookie.getName());
					return cookie;
				}
			}
			logger.info("application cookie not found");
		}
		logger.info("no cookies present in the request");
		return null;
	}

}
