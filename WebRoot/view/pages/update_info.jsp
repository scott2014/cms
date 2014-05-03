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
<link href="<%=basePath%>/view/pages/create_shiji.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/create_shiji.js"></script>


<title>无标题文档</title>
</head>

<body>
<div id="create_shiji">
<form id="form1" name="form1" method="post" action="<%=basePath %>/user!updateInfo" enctype="multipart/form-data">
<table cellspacing="0" cellpadding="0" bgcolor="#1C80B7" width="98%"
			align="center" border="0" class="tablect" style="padding:3px">
			<tbody>
				<tr bgcolor="#FFFFFF">
					<td>头像：</td>
					<td align="left">
						<img src="<%=basePath %>/<s:property value='#session.user.photo'/>"/>
						<input type="file" name="photo" />
					</td>
					<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>真实姓名：</td>
					<td align="left">
						<input type="text" value="<s:property value='#session.user.realName'/>" name="user.realName"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td> 邮箱：</td>
					<td align="left">
						 <input type="text" name="user.email" value="<s:property value='#session.user.email'/>"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> QQ：</td>
					<td align="left">
						 <input type="text" name="user.qq" value="<s:property value='#session.user.qq'/>"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 手机：</td>
					<td align="left">
						 <input type="text" name="user.phone" value="<s:property value='#session.user.phone'/>"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 地址：</td>
					<td align="left">
						 <input type="text" name="user.address" value="<s:property value='#session.user.address'/>"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 单位(大学)：</td>
					<td align="left">
						 <input type="text" name="user.university" value="<s:property value='#session.user.university'/>"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 学院(所)：</td>
					<td align="left">
						 <input type="text" name="user.department" value="<s:property value='#session.user.department'/>"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>系(部门)：</td>
					<td align="left">
						 <input type="text" name="user.faculty" value="<s:property value='#session.user.faculty'/>"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>个人简介：</td>
					<td align="left">
						  <textarea name="user.description"><s:property value='#session.user.description'/></textarea>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td align="center" colspan="2">
						<input type="submit" value="提交" style="width:60px;"/> 
						<input type="reset" value="重置"  style="width:60px;"/>
        			</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>