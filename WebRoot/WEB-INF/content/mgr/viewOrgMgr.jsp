<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>查看机构</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>
<table width="780" align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
<tr>
<td>
<br>
<s:if test="#{requestScope.msg}!=null">
<div align="center" class="error">${requestScope.msg}</div></s:if>
<table width="80%" border="0" align="center" 
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="3" ><div class="mytitle">您正在查看机构信息</div></td> 
  </tr>
  <tr class="pt9" height="30">
	<td><b>机构ID</b></td>
	<td><b>机构名</b></td>
	<td><b>操作</b></td>
  </tr>
<s:iterator value="orgList" status="index">  
 	<tr class="pt9" height="24">	
	<td><s:property value="id"/></td>
	<td><s:property value="orgName"/></td>
	<td><div align="center">
		<s:url id="orgDetail" action="orgDetail" >
   			<s:param name="org.id"><s:property value="id" /></s:param>
   		</s:url>
	<s:a href="%{orgDetail}">查看</s:a></div>
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