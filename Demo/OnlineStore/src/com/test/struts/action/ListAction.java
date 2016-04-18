package com.test.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.LazyValidatorForm;

import com.test.common.Constants;
import com.test.domain.Cart;
import com.test.domain.Product;
import com.test.service.ProductService;

public class ListAction extends DispatchAction {

	// 引用业务层的productService
	private ProductService productService;

	// productService的setter方法
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 来到商品列表页面
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 通过业务对想获取所有的商品
		List<Product> list = productService.getAllProducts();
		request.setAttribute(Constants.REQ_PRODUCTS, list);
		return mapping.findForward("list");
	}

	// 向购物车里添加商品项
	public ActionForward addItem(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 获得动态Form
		LazyValidatorForm f = (LazyValidatorForm) form;
		Long productId = Long.valueOf((String) f.get("productId"));
		// 通过商品id获取商品对象
		Product product = productService.getProduct(productId);
		// 判断Session里的Cart是否为空，如果为空，重新创造
		Cart cart = (Cart) request.getSession().getAttribute(
				Constants.SESSION_CART);
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute(Constants.SESSION_CART, cart);
		}
		// 为当前购物车里添加一个商品
		cart.addItem(product, 1);
		return index(mapping, form, request, response);
	}
}
