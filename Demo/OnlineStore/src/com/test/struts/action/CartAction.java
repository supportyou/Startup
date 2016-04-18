package com.test.struts.action;

import org.apache.struts.actions.DispatchAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.test.common.Constants;
import com.test.domain.Cart;

public class CartAction extends DispatchAction {

	private Logger logger = Logger.getLogger(this.getClass());

	// 来到购物车页面
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 获得动态Form
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.SESSION_CART);
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute(Constants.SESSION_CART,
					new Cart());
		}
		return mapping.findForward("cart");
	}

	// 修改购物车里添加商品项的数量
	public ActionForward modifyItemNumber(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String[] itemCheck = request.getParameterValues("itemCheck");
		if (itemCheck == null || itemCheck.length == 0) {
			return mapping.findForward("cart");
		}
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.SESSION_CART);
		for (String productId : itemCheck) {
			String number = request.getParameter("number" + productId);
			cart.modifyNumberByProductId(Long.valueOf(productId),
					Integer.valueOf(number));
		}
		return mapping.findForward("cart");
	}

	// 删除购物车的商品项目
	public ActionForward deleteItem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String[] itemCheck = request.getParameterValues("itemCheck");
		if (itemCheck == null || itemCheck.length == 0) {
			return mapping.findForward("cart");
		}
		logger.info("Deleting item size=" + itemCheck.length);
		Long[] productIds = new Long[itemCheck.length];
		for (int i = 0; i < productIds.length; i++) {
			productIds[i] = Long.valueOf(itemCheck[i]);
		}
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.SESSION_CART);
		cart.deleteItemByProductId(productIds);
		return mapping.findForward("cart");
	}

	// 清空购物车页面
	public ActionForward clear(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("Cart is clearing...");
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.SESSION_CART);
		cart.clear();
		return mapping.findForward("cart");
	}

}
