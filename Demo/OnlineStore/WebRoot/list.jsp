<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>我的购物车</TITLE>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	</HEAD>
	<BODY bgColor=#ffffff>
		<H1 align=center>
			本系统的所有商品列表如下：
			<BR>
			<BR>
			<TABLE width=300 border=1>
				<TBODY>
					<TR height=25>
						<TD>
							产品名称
						</TD>
						<TD>
							添加到购物车
						</TD>
					</TR>
					<c:forEach var="p" items="${requestScope.products}">
					<TR>
						<TD>
							${p.name}
						</TD>
						<TD>
							<A href="ListAction.do?method=addItem&productId=${p.id}">添加到购物车</A>
						</TD>
					</TR>
					</c:forEach>
				</TBODY>
			</TABLE>
			<BR>
			<A href="CartAction.do?method=index">查看购物车</A>&nbsp;&nbsp;
			<A href="OrderAction.do?method=index">结账</A>&nbsp;&nbsp;
			<A href="login.jsp">登录</A>
		</H1>
	</BODY>
</HTML>