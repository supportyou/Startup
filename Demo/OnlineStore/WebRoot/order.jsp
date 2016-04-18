<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>我的购物车</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
	</HEAD>
	<BODY bgColor=#ffffff>
		<H1 align=center>
			你所购买的商品如下：
		</H1>
		<TABLE cellSpacing=0 cellPadding=0 width="75%" align=center border=1>
			<TBODY>
				<TR align=middle>
					<TD width="21%" height=30>
						商品名称
					</TD>
					<TD width="14%" height=30>
						单价
					</TD>
					<TD width="25%" height=30>
						数量
					</TD>
					<TD width="33%" height=30>
						合计
					</TD>
				</TR>
				<c:forEach var="item" items="${sessionScope.cart.items}">
					<TR align=middle>
						<TD height=30>
							${item.value.product.name }
						</TD>
						<TD height=30>
							${item.value.product.price }
						</TD>
						<TD height=30>
							${item.value.number }
						</TD>
						<TD height=30>
							${item.value.cost }
						</TD>
					</TR>
				</c:forEach>
				<TR>
					<TD colSpan=5 height=30>
						您的购物车中所有商品总金额：${sessionScope.cart.price }
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<P>
		<H1 align=center>
			用户联系方式如下：
		</H1>
		<P></P>
		<html:form action="/OrderAction" method="post">
			<html:hidden property="method" value="postOrder" />
			<TABLE cellSpacing=0 cellPadding=0 width=500 align=center border=0>
				<TBODY>
					<TR>
						<TD width=117 height=23>
							姓名：
						</TD>
						<TD width=383>
							<INPUT value="${sessionScope.user.name }" name="name">
						</TD>
					</TR>
					<TR>
						<TD height=24>
							地址：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.address }" name="address">
						</TD>
					</TR>
					<TR>
						<TD height=24>
							邮政编码：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.postCode }" name="postCode">
						</TD>
					</TR>
					<TR>
						<TD height=23>
							E-mail：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.email }" name="email">
						</TD>
					</TR>
					<TR>
						<TD height=23>
							联系电话：
						</TD>
						<TD>
							<INPUT value="${sessionScope.user.cellPhone }" name="phone">
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			<TABLE cellSpacing=0 cellPadding=0 width=500 align=center border=0>
				<TBODY>
					<TR>
						<TD align=middle>
							<INPUT type=submit value=结帐 name=Submit>
						</TD>
						<TD align=middle>
							<INPUT
								onclick="javascript:location.href='ListAction.do?method=index'"
								type=button value="继续购物" name=Submit42>
						</TD>
						<TD align=middle>
							<INPUT
								onclick="javascript:location.href='CartAction.do?method=index'"
								type=button value="回到购物车" name=Submit42>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</html:form>
	</BODY>
</HTML>