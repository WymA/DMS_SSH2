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
	<td colspan="5" ><div class="mytitle">�ѷ����û���Ϣ</div></td> 
  </tr>
  <tr class="pt9" height="30">
	<td width="50"><b>�û�ID</b></td>
	<td width="100"><b>�û���</b></td>
	<td width="120"><b>����Ȩ��</b></td>
	<td width="60"><b>�ʺŹ���</b></td>
	<td width="60"><b>��������</b></td>
  </tr>
<s:iterator value="userList" status="status">  
 	<tr class="pt9" height="24">
	<td><s:property value="id"/></td>
	<td><s:property value="username"/></td>
	<td><s:property value="%{roleList[#status.index].rolename}"/></td>
	<td>
	<div align="center" >
		<s:set name="userId"><s:property value='id' /></s:set>
		<s:form action="deleteUser?user.id=%{userId}">
			<s:submit value="ɾ��" />
		</s:form>
	</div>
	</td>
	<td>
	<div align="center" >
		<s:form action="lockUser?user.id=%{userId}">
			<s:submit value="����" />
		</s:form>
	</div>
	</td>
	
  </tr>
</s:iterator>  
  <tr bgcolor="#e1e1e1" >
	<td colspan="5" ><div class="mytitle">δ�����û���Ϣ</div></td> 
  </tr>
  <tr class="pt9" height="30">
	<td width="50"><b>�û�ID</b></td>
	<td width="100"><b>�û���</b></td>
	<td><b>Ȩ�޹���</b></td>
	<td width="60"><b>�ʺŹ���</b></td>
	<td width="60"><b>��������</b></td>
  </tr>
<s:iterator value="user2List" status="status">  
 	<tr class="pt9" height="24">
	<td><s:property value="id"/></td>
	<td><s:property value="username"/></td>
	<td>
		<s:form action="assignUser" theme="simple">	
			<s:select list="branchList" value="%{branchList.branchName}" 
	name="branch.branchName" listKey="branchName" listValue="branchName" />
			<s:submit value="����"/>
		</s:form>
	</td>
	<td>
	<div align="center" >
		<s:set name="userId"><s:property value='id' /></s:set>
		<s:form action="deleteUser?user.id=%{userId}">
			<s:submit value="ɾ��" />
		</s:form>
	</div>
	</td>
	<td>
	<div align="center" >
		<s:form action="lockUser?user.id=%{userId}">
			<s:submit value="����" />
		</s:form>
	</div>
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