<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>经理首页</title>
</head>
<body>
<%@include file="../header.jsp"%> 
<%@include file="mgrheader.jsp"%> 
<table width="780" align="center" 
	background="images/bodybg.jpg">
  <tr height="60">
	<td>&nbsp;</td>
  </tr>
  <tr>
	<td>
<s:if test="tip!=null">
<div class="mytitle">
	<s:property value="tip"/>
</div>
</s:if>	
	</td>
  </tr>
  <tr height="80">
	<td>&nbsp;</td>
  </tr>
  <tr>
	<td><s:property value="#session.user"/> ，
		欢迎您使用多级文件机构管理系统</td>
  </tr>
  <tr height="60">
	<td>&nbsp;</td>
  </tr>
</table>
<%@include file="../footer.jsp"%> 
</body>
</html>
