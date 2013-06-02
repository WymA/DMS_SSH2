<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="userheader.jsp"%>
<table width="780" align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
<tr>
<td>
<br>
<table width="80%" border="0" align="center" 
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="2" ><div class="mytitle">个人信息</div></td> 
  </tr>
  <tr class="pt9" height="30">
	<td><b>用户ID</b></td>
	<td><s:property value="user.id" /></td>
  </tr>
  <tr>
  <td><b>用户名</b></td>
  <td><s:property value="user.username" /></td>
  </tr>
  <tr>
  <td><b>所属部门</b></td>
  <td><s:property value="branch.branchName" /></td>
  </tr>
  
</table>
</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>