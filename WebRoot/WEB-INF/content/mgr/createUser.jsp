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
������Ҫ�������û���������<br />
<s:actionerror cssClass="error"/>
<div align="center">
<s:form action="createUser" >
	<s:textfield name="user.username" label="�û���"/>
	<s:password name="user.password" label="����"/>
	<s:password name="repassword" label="ȷ������"/>
	<tr><td colspan="2">
	<s:submit value="ȷ�����" theme="simple"/><s:reset theme="simple" value="����"/>
	</td></tr>
</s:form>
</div>
</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>
