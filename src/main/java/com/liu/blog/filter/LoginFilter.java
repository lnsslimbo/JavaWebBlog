
package com.liu.blog.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(
		urlPatterns = {"/*"}
)
public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String url = httpRequest.getServletPath();

		if (!url.equals("/login") && !url.equals("/register") &&
				!url.equals("/manageArticle") && !url.equals("/searchArticle") &&
				!url.equals("/searchUser") && !url.equals("/displayArticle") &&
				!url.equals("/displayArticleType") && !url.equals("/manageArticleByUser") &&
				!url.equals("/manageArticleByUserNameAndArticleType") &&
				!url.equals("/manageReply") &&!url.equals("/manageDisplayArticle")&&
				!url.equals("/manageChangeArticle")&&!url.equals("/deleteArticle")) {
			HttpSession session = httpRequest.getSession();
			String userName = (String) session.getAttribute("UserName");
			if (userName == null || userName.equals("")) {
				((HttpServletResponse) response).sendRedirect("login");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) {

	}

}