package com.test.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.test.common.Constants;
import com.test.domain.Cart;
import com.test.domain.Order;
import com.test.domain.User;
import com.test.service.OrderService;

public class OrderAction extends DispatchAction {

	// 引用业务层的generalService
	private OrderService orderService;

	// service的setter方法
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// 来到商品列表页面
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(
				Constants.SESSION_USER);
		if (user == null) {
			return mapping.findForward("login");
		}
		return mapping.findForward("order");
	}

	// 提交订单
	public ActionForward postOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(
				Constants.SESSION_USER);
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.SESSION_CART);
		// 把购物车里的信息产生订单的信息
		Order order = new Order();
		order.setUser(user);
		order.setItems(cart.getItems());
		order.setStatus(Constants.ORDER_STATUS_POST);
		// 调用业务层，产生新订单
		String orderNum = orderService.generateOrder(order);
		request.setAttribute(Constants.REQ_ORDER_NUMBER, orderNum);
		return mapping.findForward("succ");
	}
}
