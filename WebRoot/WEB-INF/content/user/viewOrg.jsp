<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>�鿴����</title>
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
	<td><b>����ID</b></td>
	<td><b>������</b></td>
	<td><b>����</b></td>
  </tr>
<s:iterator value="orgList" status="index">  
 	<tr class="pt9" height="24">	
	<td><s:property value="id"/></td>
	<td><s:property value="orgName"/></td>
	<td><div align="center">
		<s:url id="orgInfo" action="orgInfo" >
   			<s:param name="org.id"><s:property value="id" /></s:param>
   		</s:url>
	<s:a href="%{orgInfo}">�鿴</s:a></div>
	</td>
  </tr>
</s:iterator>  
</table>
</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>