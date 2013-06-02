<%@ page contentType="text/html; charset=GBK" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title></title>
<s:head/>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="./mgrheader.jsp"%>

<table width=780 align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
<tr >
<td >
请输入要创建的用户名和密码<br />
<s:actionerror cssClass="error"/>
<div align="center">
<s:form action="createUser" >
	<s:textfield name="user.username" label="用户名"/>
	<s:password name="user.password" label="密码"/>
	<s:password name="repassword" label="确认密码"/>
	<tr><td colspan="2">
	<s:submit value="确认添加" theme="simple"/><s:reset theme="simple" value="重填"/>
	</td></tr>
</s:form>
</div>
</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>
