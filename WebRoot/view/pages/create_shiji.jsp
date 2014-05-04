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
<form id="form1" name="form1" method="post" action="<%=basePath %>/medicinal" enctype="multipart/form-data">
<table cellspacing="0" cellpadding="0" bgcolor="#1C80B7" width="98%"
			align="center" border="0" class="tablect" style="padding:3px">
			<tbody>
				<tr bgcolor="#FFFFFF">
					<td>图片：</td>
					<td align="left">
						<input type="file" name="photo" />
					</td>
					<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>产品编号：</td>
					<td align="left">
						<input type="text" name="medicinal.no"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>所属试剂库：</td>
					<td align="left">
						<select name="medicinal.repositoryId" id="shiji_select" style="height:26px;">
        					<s:iterator value="myrepos">
        						<option value='<s:property value="id"/>'>
        							<s:property value="repoName"/>
        						</option>
        				</s:iterator>
        				</select>	
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td> 分子式：</td>
					<td align="left">
						 <input type="text" name="medicinal.formula"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 中文名称：</td>
					<td align="left">
						 <input type="text" name="medicinal.name"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> CAS：</td>
					<td align="left">
						  <input type="text" name="medicinal.cas"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 规格：</td>
					<td align="left">
						 <input type="text" name="medicinal.standard"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 数量：</td>
					<td align="left">
						 <input type="text" name="medicinal.left"/>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 用途：</td>
					<td align="left">
						  <textarea name="medicinal.musage"></textarea>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 危险性：</td>
					<td align="left">
						  <textarea name="medicinal.security"></textarea>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>形状：</td>
					<td align="left">
						  <textarea name="medicinal.shape"></textarea>
        			</td>
        			<td align="left">
					    <span></span>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>说明：</td>
					<td align="left">
						  <textarea name="medicinal.description"></textarea>
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
