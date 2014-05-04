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
	      <td width="40%" align="center">&nbsp;<input type="text" name="repository.repoNo"/></td>
          <td width="30%" class="tip" id="tip_repoNo"><span></span></td>
        </tr>
	    <tr>
	      <td>试剂库名称：</td>
	      <td>&nbsp;<input type="text" name="repository.repoName"/></td>
           <td class="tip" id="tip_repoName"><span></span></td>
        </tr>
	    <tr>
	      <td>所在单位名称：</td>
	      <td>&nbsp;<input type="text" name="repository.university"/></td>
          <td class="tip" id="tip_university"><span></span></td>
        </tr>
	    <tr>
	      <td>所在学院名称：</td>
	      <td>&nbsp;<input type="text" name="repository.department"/></td>
          <td class="tip" id="tip_department"><span></span></td>
        </tr>
	    <tr>
	      <td>所在系名称：</td>
	      <td>&nbsp;<input type="text" name="repository.faculty"/></td>
          <td class="tip" id="tip_faculty"><span></span></td>
        </tr>
	    <tr>
	      <td>所在团队名称：</td>
	      <td>&nbsp;<input type="text" name="repository.team" /></td>
          <td class="tip" id="tip_team"><span></span></td>
        </tr>
	    <tr>
	      <td height="38">存放地点：</td>
          <td>&nbsp;<input type="text" name="repository.address"/></td>
          <td class="tip" id="tip_address"><span></span></td>
        </tr>
        <tr>
	      <td height="38">属性：</td>
          <td>&nbsp;<input type="text" name="repository.fields" /></td>
          <td class="tip" id="tip_fields"><span></span></td>
        </tr>
        <tr>
	      <td height="38">建议：</td>
          <td>&nbsp;
          	<textarea rows="10" cols="50" name="repository.advice"></textarea>
          </td>
          <td class="tip" id="tip_advice"><span></span></td>
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
