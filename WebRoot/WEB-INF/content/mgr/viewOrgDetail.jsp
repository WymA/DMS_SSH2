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
	<td><b>������</b></td>
	<s:if test="org.parentOrg.orgName==org.orgName" >
		<td>��</td>
	</s:if>
	  <s:else>
	<td><s:property value="org.parentOrg.orgName"/></td>
	 </s:else>
  </tr>

  
  <tr class="pt9" height="24">
	<td><b>����Ա</b></td>
	  <s:if test="mgrs.size==0">
	  	<td>����</td>
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
	<td><b>ָ������Ա</b></td>
	<td>
	<s:form action="mgrOfOrg" theme="simple" method="post">	
	<s:select list="users" value="%{users.username}" 
	name="user.username" listKey="username" listValue="username" >
	</s:select>
   	<s:hidden name="org.id" value="%{org.id }" />
	<s:submit value="ȷ��" /> 
	</s:form> 
	</td>
  </tr>
    
  <tr class="pt9" height="24">
	<td><b>�����û�</b></td>
	<td>
	<s:form action="userOfOrg" theme="simple" >
	<s:select list="users" value="%{users.username}" 
	name="user.username" listKey="username" listValue="username" />
	<s:select list="branches" value="%{branches.branchName}" 
	name="branch.branchName" listKey="branchName" listValue="branchName" />
	<s:submit value="ȷ��"/>
	</s:form>
	</td>
  </tr>
  
  <tr class="pt9" height="24">
	<td><b>�����ӻ���</b></td>
	<td>
	<s:form action="childOfOrg" theme="simple" >
		<s:hidden name="org.id" value="%{org.id }" />
		<s:label value="�ӻ�������" />
		<s:textfield name="childOrg.orgName" />
		<s:submit value="�ύ"/>
	</s:form>
	</td>
  </tr>
  
   <tr class="pt9" height="24">
	<td><b>��������</b></td>
	<td>
	<s:form action="branchOfOrg" theme="simple" >
		<s:hidden name="org.id" value="%{org.id}" />
		<s:label value="��������" />
		<s:textfield name="branch.branchName" />
		<s:submit value="�ύ"/>
	</s:form>
	</td>
  </tr>


	<tr class="pt9" height="30" >
	<td >
	<s:form action="deleteOrg" theme="simple" >
		<s:hidden name="org.id" value="%{orgId}" />
		<s:submit value="ɾ��������"/>
	</s:form>
</td>
	<td>
	<s:form action="addOrg" theme="simple" >
		<s:hidden name="org.id" value="%{orgId}" />
		<s:submit value="��������"/>
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