<%@ page contentType="text/html; charset=GBK" import="java.util.*" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<s:head/>
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
  		<tr>
  		<td colspan="3" >	
			<s:form action="fileMgr" theme="simple">
			<s:label value="ѡ�������" />
				<s:select list="orgList" value="%{orgList.orgName}" 
	name="org.orgName" listKey="orgName" listValue="orgName" />
				<s:submit value="�鿴" />
			</s:form>
		</td>
		</tr>
		<tr bgcolor="#e1e1e1" >	
		<td colspan="3" ><div class="mytitle">�����ڲ鿴�ļ�������Ϣ</div></td> 	
	  	</tr>
           <tr class="pt9" height="30" >
           <td width="10%">�ļ�ID</td>
           <td width="80%">�ļ���</td>  
           <td width="10%">����</td>  
           </tr>  
            <s:iterator status="status" value="fileList" >  
             <tr class="pt9" height="24" >
             <td><s:property value="id" /></td>  
             <td><s:property value="fileName" /></td>  
             <td><s:a action="downloadPro" encode="false">  
                <s:param name="fileName" value="%{fileName}" />����</s:a>  
             </td>  
             </tr>  
           </s:iterator>  
           <tr>
	      <s:form action="uploadPro" method="post" 
	      enctype="multipart/form-data" label="�ļ��ϴ�" theme="simple"> 
	      	<td>�ļ��ϴ�</td> 
	      	<td><s:file name="upload" />
	        <s:submit name="submit" value="�ύ" /></td>
	        <td><s:fielderror name="isSuccess" /></td>
	      </s:form>  
          </tr>
        </table>    
        </td>
        </tr>
        <tr>
       </table>   
     <%@include file="../footer.jsp"%>
	</body>
</html>
