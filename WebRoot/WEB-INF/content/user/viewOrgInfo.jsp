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
	<td colspan="3" ><div class="mytitle">�����ڲ鿴������Ϣ</div></td> 
  </tr>
  
  <tr class="pt9" height="30">
	<td width="50%"><b>������</b></td>
	<td width="50%"><s:property value="org.orgName"/></td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>����ID</b></td>
	<td><s:property value="org.id"/></td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>������ID</b></td>
	<td><s:property value="org.parentOrg.id"/></td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>����Ա</b></td>
	<td><s:property value="user.username" /></td>
  </tr>
    
</table>

</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>