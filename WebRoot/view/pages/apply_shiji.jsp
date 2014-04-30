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
<link href="<%=basePath%>/view/pages/apply_shiji.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/create_shiji.js"></script>


<title>无标题文档</title>
</head>

<body>
<div id="create_shiji">
<form id="form1" name="form1" method="post" action="<%=basePath %>/medicinal" enctype="multipart/form-data">
<table cellspacing="0" cellpadding="0" bgcolor="#1C80B7" width="98%"
			align="center" border="0" class="tablect" style="padding:3px">
			<tbody>
				<tr bgcolor="#FFFFFF">
					<td width="20%">图片：</td>
					<td align="left">
						<img src="<%=basePath%>/<s:property value='mVO.medicinal.photo' />"/>
					</td>
					<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>产品编号：</td>
					<td align="left">
						<s:property value='mVO.medicinal.no' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>所属试剂库：</td>
					<td align="left">
						<s:property value='mVO.repository.repoName' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td> 分子式：</td>
					<td align="left">
						<s:property value='mVO.medicinal.formula' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 中文名称：</td>
					<td align="left">
						<s:property value='mVO.medicinal.name' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> CAS：</td>
					<td align="left">
						<s:property value='mVO.medicinal.cas' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 规格：</td>
					<td align="left">
						<s:property value='mVO.medicinal.standard' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 用途：</td>
					<td align="left">
						<s:property value='mVO.medicinal.musage' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 危险性：</td>
					<td align="left">
						<s:property value='mVO.medicinal.security' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>形状：</td>
					<td align="left">
						<s:property value='mVO.medicinal.shape' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>说明：</td>
					<td align="left">
						<s:property value='mVO.medicinal.description' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>试剂管理员：</td>
					<td align="left">
						<s:property value='mVO.user.username' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>剩余数量：</td>
					<td align="left">
						<s:property value='mVO.medicinal.left' />
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>申请数量：</td>
					<td align="left">
						<input type="text"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td align="center" colspan="3">
						<input type="submit" value="提交申请" style="width:60px;"/> 
						<input type="reset" value="重置"  style="width:60px;"/>
        			</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
