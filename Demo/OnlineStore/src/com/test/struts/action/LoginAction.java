package com.test.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.LazyValidatorForm;

import com.test.common.Constants;
import com.test.domain.Administrator;
import com.test.domain.User;
import com.test.service.UserService;

public class LoginAction extends Action {

	//引入用户服务对象userService
		private UserService userService;

		// userService的setter方法
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		//动作方法
		public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {
			LazyValidatorForm f = (LazyValidatorForm) form;
			String username = (String) f.get("username");		//获取用户名参数
			String password = (String) f.get("password");		//获取密码参数
			User user = userService.login(username, password);	//调用业务方法login
			//如果user为空，则登录失败
			if (user == null) {
				request.setAttribute("msg", "登录失败");
				return mapping.findForward("login");
			} else {
				request.getSession().setAttribute(Constants.SESSION_USER, user);
				//判断是否为管理员，若是则转后台界面
				if (user instanceof Administrator) {			
					return mapping.findForward("manage");
				} else {
					return mapping.findForward("succ");
				}
			}
		}
}
