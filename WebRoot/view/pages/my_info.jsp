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
<link href="<%=basePath%>/view/pages/my_info.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/my_info.js"></script>


<title>个人信息修改</title>
</head>

<body>
<div id="create_shiji">
<table cellspacing="0" cellpadding="0" bgcolor="#1C80B7" width="98%"
			align="center" border="0" class="tablect" style="padding:3px">
			<tbody>
				<tr bgcolor="#FFFFFF">
					<td width="25%">头像：</td>
					<td align="left">
						<img src="<%=basePath %>/<s:property value='#session.user.photo'/>"/>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>用户名：</td>
					<td align="left">
						<s:property value='#session.user.username'/>
        			</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>真实姓名：</td>
					<td align="left">
						<s:property value='#session.user.realName'/>
        			</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td> 邮箱：</td>
					<td align="left">
						<s:property value='#session.user.email'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> QQ：</td>
					<td align="left">
						<s:property value='#session.user.qq'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 手机：</td>
					<td align="left">
						<s:property value='#session.user.phone'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 地址：</td>
					<td align="left">
						<s:property value='#session.user.address'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 单位(大学)：</td>
					<td align="left">
						<s:property value='#session.user.university'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 学院(所)：</td>
					<td align="left">
						<s:property value='#session.user.department'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>系(部门)：</td>
					<td align="left">
						<s:property value='#session.user.faculty'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>个人简介：</td>
					<td align="left">
						<s:property value='#session.user.description'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td align="center" colspan="2">
						<input type="button" value="修改个人信息" style="width:60px;"/> 
        			</td>
				</tr>
			</tbody>
		</table>
</div>
</body>
</html>
