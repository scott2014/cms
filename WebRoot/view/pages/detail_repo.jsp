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

<link href="<%=basePath%>/view/pages/detail_repo.css" rel="stylesheet" type="text/css" />
<title>试剂库详情</title>
</head>

<body>
	<div id="shijiku">
		<table cellspacing="1" cellpadding="0" bgcolor="#1C80B7" width="98%"
			align="center" border="0" class="tablect" style="padding:3px">
			<tbody>
				<tr bgcolor="#FFFFFF">
					<td colspan="3" class="head">
						试剂库详情
					</td>
				</tr>
				<tr bgcolor="#1C80B7">
					<th>试剂库编号</th>
					<th>试剂库名称</th>
					<th>试剂库所在单位</th>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td><s:property value="nRepoVO.repository.repoNo" /></td>
					<td><s:property value="nRepoVO.repository.repoName" /></td>
					<td><s:property value="nRepoVO.repository.university" /></td>
				</tr>
				
				<tr bgcolor="#1C80B7">
					<th>试剂库所在学院</th>
					<th>试剂库所在系</th>
					<th>试剂库所在团队</th>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td><s:property value="nRepoVO.repository.department" /></td>
					<td><s:property value="nRepoVO.repository.faculty" /></td>
					<td><s:property value="nRepoVO.repository.team" /></td>
				</tr>
				<tr bgcolor="#1C80B7">
					<th>试剂库属性</th>
					<th>相关建议</th>
					<th>创建日期</th>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td><s:property value="nRepoVO.repository.fields" /></td>
					<td><s:property value="nRepoVO.repository.advice" /></td>
					<td><s:date name="nRepoVO.repository.createTime" format="yyyy-MM-dd HH:mm"/></td>
				</tr>

				<tr bgcolor="#FFFFFF">
					<td colspan="3" class="head">创建人：<s:property value="nRepoVO.user.username" />
					</td>
				</tr>
				
				<tr bgcolor="#1C80B7">
					<th>
						QQ
					</th>
					<th>
						邮箱
					</th>
					<th>
						手机号
					</th>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td><s:property value="nRepoVO.user.qq" />
					</td>
					<td><s:property value="nRepoVO.user.email" />
					</td>
					<td><s:property value="nRepoVO.user.phone" />
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td class="head" colspan="5">试剂库中所有试剂</td>
				</tr>
				
				<tr bgcolor="#1C80B7">
					<th width="15%">图片说明</th>
					<th width="20%">分子式</th>
					<th width="20%">试剂名称</th>
				</tr>

				<s:iterator value="nRepoVO.medicinals" var="m">
					<tr bgcolor="#FFFFFF">
						<td>
							<a href="<%=basePath %>/medicinal!toDetail?id=<s:property value='#m.id'/>">
								<img src="<%=basePath %>/<s:property value='#m.photo' />" alt="" />
							</a>
						</td>
						<td>
							<a href="<%=basePath %>/medicinal!toDetail?id=<s:property value='#m.id'/>">
								<s:property value="#m.formula" />
							</a>
						</td>
						<td>
							<a href="<%=basePath %>/medicinal!toDetail?id=<s:property value='#m.id'/>">
								<s:property value="#m.name" />
							</a>
						</td>
					</tr>
				</s:iterator>
				<tr bgcolor="#FFFFFF">
					<td colspan="3">
						<div id="mypage">
							<div id="pagination"></div>
						</div></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
