package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.common.Constants;
import com.test.domain.Administrator;
import com.test.domain.User;


//后台过滤器
public class ManageFilter implements Filter {

	public void destroy() {
	}
	//过滤动作方法
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		//如果session为新的或没有用户在session里面，或者用户的类型不是管理员类型，则转到登录页面
		if (session.isNew() || session.getAttribute(Constants.SESSION_USER) == null) {
			User user = (User) session.getAttribute(Constants.SESSION_USER);
			if (!(user instanceof Administrator)) {
				String contextPath = ((HttpServletRequest)request.getSession().getServletContext()).getContextPath();
				response.sendRedirect(contextPath + "/login.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}