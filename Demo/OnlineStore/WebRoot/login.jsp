<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>我的购物车</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	</HEAD>
	<BODY bgColor=#ffffff>
		<H1 align=center>
			用户登录
			<br>
			<font color="red">${requestScope.msg}</font>
			<br>
			<html:form action="/login">
			用户名：<html:text property="username"></html:text>
				<br>
			密码：<html:password property="password"></html:password>
				<br>
				<html:submit>提交</html:submit>
			</html:form>
		</H1>
	</BODY>
</HTML>