<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>

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
	<td><b>父机构</b></td>
	<s:if test="org.parentOrg.orgName==org.orgName" >
		<td>无</td>
	</s:if>
	  <s:else>
	<td><s:property value="org.parentOrg.orgName"/></td>
	 </s:else>
  </tr>

  
  <tr class="pt9" height="24">
	<td><b>管理员</b></td>
	  <s:if test="mgrs.size==0">
	  	<td>暂无</td>
	  </s:if>
  	<s:else>
	<td>
	<s:iterator value="mgrs" status="index" >
		<s:property value="username" />&nbsp;
	</s:iterator>
	</td>	
	 </s:else>
  </tr>

  
  <tr class="pt9" height="24">
	<td><b>指定管理员</b></td>
	<td>
	<s:form action="mgrOfOrg" theme="simple" method="post">	
	<s:select list="users" value="%{users.username}" 
	name="user.username" listKey="username" listValue="username" >
	</s:select>
   	<s:hidden name="org.id" value="%{org.id }" />
	<s:submit value="确认" /> 
	</s:form> 
	</td>
  </tr>
    
  <tr class="pt9" height="24">
	<td><b>分配用户</b></td>
	<td>
	<s:form action="userOfOrg" theme="simple" >
	<s:select list="users" value="%{users.username}" 
	name="user.username" listKey="username" listValue="username" />
	<s:select list="branches" value="%{branches.branchName}" 
	name="branch.branchName" listKey="branchName" listValue="branchName" />
	<s:submit value="确认"/>
	</s:form>
	</td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>创建子机构</b></td>
	<td>
	<s:form action="childOfOrg" theme="simple" >
		<s:hidden name="org.id" value="%{org.id }" />
		<s:label value="子机构名：" />
		<s:textfield name="childOrg.orgName" />
		<s:submit value="提交"/>
	</s:form>
	</td>
  </tr>
  
   <tr class="pt9" height="24">
	<td><b>创建部门</b></td>
	<td>
	<s:form action="branchOfOrg" theme="simple" >
		<s:hidden name="org.id" value="%{org.id}" />
		<s:label value="部门名：" />
		<s:textfield name="branch.branchName" />
		<s:submit value="提交"/>
	</s:form>
	</td>
  </tr>


	<tr class="pt9" height="30" >
	<td >
	<s:form action="deleteOrg" theme="simple" >
		<s:hidden name="org.id" value="%{orgId}" />
		<s:submit value="删除本机构"/>
	</s:form>
</td>
	<td>
	<s:form action="addOrg" theme="simple" >
		<s:hidden name="org.id" value="%{orgId}" />
		<s:submit value="创建机构"/>
	</s:form>
	</td>

	</tr>


  
</table>

</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>