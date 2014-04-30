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
<script type="text/javascript" src="<%=basePath %>/view/assets/create_repo.js"></script>

<title>实验室药品管理系统</title>
</head>

<body>
	<div id="repo">
	  <div id="repo_table">
	  <form action="<%=basePath %>/repository" method="post" id="form">
      	<table width="96%" border="0">
	    <tr>
	      <td width="15%">试剂库编号：</td>
	      <td width="40%" align="center">&nbsp;<input type="text" name="repositoryVO.repoNo"/></td>
          <td width="30%" class="tip" id="tip_repoNo"><span></span></td>
        </tr>
	    <tr>
	      <td>试剂库名称：</td>
	      <td>&nbsp;<input type="text" name="repositoryVO.repoName"/></td>
           <td class="tip" id="tip_repoName"><span></span></td>
        </tr>
	    <tr>
	      <td>所在单位：</td>
	      <td>&nbsp;<input type="text" name="repositoryVO.department"/></td>
          <td class="tip" id="tip_department"><span></span></td>
        </tr>
	    <tr>
	      <td>存放地点：</td>
	      <td>&nbsp;<input type="text" name="repositoryVO.address"/></td>
          <td class="tip" id="tip_address"><span></span></td>
        </tr>
	    <tr>
	      <td>邮箱：</td>
	      <td>&nbsp;<input type="text" name="repositoryVO.email" value="<s:property value='user.email'/>"/></td>
          <td class="tip" id="tip_email"><span></span></td>
        </tr>
	    <tr>
	      <td>联系电话：</td>
	      <td>&nbsp;<input type="text" name="repositoryVO.phone" value="<s:property value='user.phone'/>"/></td>
          <td class="tip" id="tip_phone"><span></span></td>
        </tr>
	    <tr>
	      <td height="38">QQ：</td>
          <td>&nbsp;<input type="text" name="repositoryVO.qq" value="<s:property value='user.qq'/>"/></td>
          <td class="tip" id="tip_qq"><span></span></td>
        </tr>
	    <tr>
	      <td height="40" colspan="3" bgcolor="#FFFFFF" class="btn">&nbsp;
          	   <input type="button" value="提交" id="tijiao"/>
               <input type="button" value="重置" id="reset"/>
           </td>
          </tr>
      </table>
      </form>
      </div>
	 
</div>
</body>
</html>
