<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>/view/pages/create_repo.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/update_pass.js"></script>

<title>实验室药品管理系统</title>
</head>

<body>
	<div id="repo">
	  <div id="repo_table">
	  	<input type="hidden" value="<s:property value='#session.user.id'/>"/>
      	<table width="96%" border="0">
		    <tr>
		      <td width="15%">原密码：</td>
		      <td width="40%" align="center">&nbsp;<input type="text" name="oldPass"/></td>
	          <td width="30%" class="tip" id="tip_oldPass"><span></span></td>
	        </tr>
		    <tr>
		      <td>新密码：</td>
		      <td>&nbsp;<input type="text" name="newPass"/></td>
	           <td class="tip" id="tip_newPass"><span></span></td>
	        </tr>
		    <tr>
		      <td>确认密码：</td>
		      <td>&nbsp;<input type="text" name="confirmPass"/></td>
	          <td class="tip" id="tip_confirmPass"><span></span></td>
	        </tr>
		    <tr>
		      <td height="40" colspan="3" bgcolor="#FFFFFF" class="btn">&nbsp;
	          	   <input type="button" value="确认" id="tijiao"/>
	               <input type="button" value="重置" id="reset"/>
	           </td>
	         </tr>
      </table>
      </div>
	 
</div>
</body>
</html>
