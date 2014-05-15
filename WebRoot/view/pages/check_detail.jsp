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
<link href="<%=basePath%>/view/pages/check_detail.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/check_detail.js"></script>


<title>无标题文档</title>
</head>

<body>
<div id="create_shiji">
<form id="form1" name="form1" method="post" action="<%=basePath %>/userMedicinal!update">
<input type="hidden" name="id" value='${id}'/>"/>
<table cellspacing="1" cellpadding="0" bgcolor="#1C80B7" width="98%"
			align="center" border="0" class="tablect" style="padding:3px">
			<tbody>
				<tr bgcolor="#FFFFFF">
					<td width="20%">图片：</td>
					<td align="left">
						<img src="<%=basePath %>/<s:property value='mVO.medicinal.photo'/>"/>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>产品编号：</td>
					<td align="left">
						<s:property value='mVO.medicinal.no'/>
        			</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td>所属试剂库：</td>
					<td align="left">
						<s:property value='mVO.repository.repoName'/>
        			</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td> 分子式：</td>
					<td align="left">
						<s:property value='mVO.medicinal.formula'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 中文名称：</td>
					<td align="left">
						<s:property value='mVO.medicinal.name'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> CAS：</td>
					<td align="left">
						<s:property value='mVO.medicinal.cas'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 规格：</td>
					<td align="left">
						<s:property value='mVO.medicinal.standard'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 用途：</td>
					<td align="left">
						<s:property value='mVO.medicinal.musage'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td> 危险性：</td>
					<td align="left">
						<s:property value='mVO.medicinal.security'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>形状：</td>
					<td align="left">
						  <s:property value='mVO.medicinal.shape'/>
        			</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td>说明：</td>
					<td align="left">
						 <s:property value='mVO.medicinal.description'/>
        			</td>
				</tr>
				
				<s:if test="mVO.um.advice == @com.cms.model.constant.UserMedicinalConst@YES">
					<tr bgcolor="#FFFFFF">
						<td>申请人建议：</td>
						<td align="left">
							试剂余量不足，建议添加
	        			</td>
					</tr>
				</s:if>
				
				<tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">
						<div style="width: 200px;height: 20px;">
								<input type="radio" name="status" value="1" checked="checked"/>审核通过&nbsp;
					    		<input type="radio" name="status" value="2"/>审核拒绝&nbsp;
						</div>
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">
						<input type="button" value="确定" id="sub"/>
					</td>
				</tr>
				
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
