<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"	prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>后台管理</TITLE>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	</HEAD>
	<BODY bgColor=#ffffff>
		<H1 align=center>
			订单列表
		</H1>
		<BR>
		<TABLE width=600 border=1 align="center">
			<TBODY>
				<TR height=25>
					<TD>
						订单状态
					</TD>
					<TD>
						订单用户名
					</TD>
					<TD>
						订单号
					</TD>
					<TD>
						订单总价
					</TD>
					<TD>
						操作
					</TD>
				</TR>
				<c:forEach var="o" items="${requestScope.orders}">
					<TR>
						<TD>
							${o.statusText}
						</TD>
						<TD>
							${o.user.name}
						</TD>
						<TD>
							${o.orderNum}
						</TD>
						<TD>
							${o.cost}
						</TD>
						<TD>
							<c:if test="${o.status != 4}">
								<A href="ManageAction.do?method=next&orderId=${o.id}">下一步</A>
							</c:if>
						</TD>
					</TR>
				</c:forEach>
			</TBODY>
		</TABLE>
		<BR>
		<center>
			<A href="<c:url value="/logout.do"/>">登出</A>
		</center>
	</BODY>
</HTML>