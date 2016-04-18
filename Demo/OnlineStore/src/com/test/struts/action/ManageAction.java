package com.test.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.LazyValidatorForm;

import com.test.common.Constants;
import com.test.domain.Order;
import com.test.service.OrderService;

public class ManageAction extends DispatchAction {

	// 引用业务层的orderService
	private OrderService orderService;

	// service的setter方法
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// 来到订单管理后台页面
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List<Order> orders = orderService.getAllOrder();
		request.setAttribute(Constants.REQ_ORDERS, orders);
		return mapping.findForward("manage");
	}

	// 让订单状态下一步
	public ActionForward next(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LazyValidatorForm f = (LazyValidatorForm) form;
		Long orderId = Long.valueOf((String) f.get("orderId"));
		// 调用业务对象，把订单的状态转到下一步
		orderService.nextOrderStatus(orderId);
		return this.index(mapping, form, request, response);
	}
}
