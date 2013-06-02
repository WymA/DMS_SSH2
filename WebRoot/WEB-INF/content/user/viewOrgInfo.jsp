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
	<td colspan="3" ><div class="mytitle">您正在查看机构信息</div></td> 
  </tr>
  
  <tr class="pt9" height="30">
	<td width="50%"><b>机构名</b></td>
	<td width="50%"><s:property value="org.orgName"/></td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>机构ID</b></td>
	<td><s:property value="org.id"/></td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>父机构ID</b></td>
	<td><s:property value="org.parentOrg.id"/></td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>管理员</b></td>
	<td><s:property value="user.username" /></td>
  </tr>
    
</table>

</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>