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
<link href="<%=basePath %>/view/pages/find_repo.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/view/assets/jPaginate/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/favorite.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/jPaginate/jquery.paginate.js"></script>

<script type="text/javascript">
	$(function() {
		$("#rpagination").paginate({
			count : parseInt($("#rpagecount").html().trim()),
			start : parseInt($("#rpagenum").html().trim()),
			display : parseInt($("#rpagesize").html().trim()),
			border : true,
			background_color : "#1C80B7",
			text_hover_color : "#000",
			background_hover_color : "rgb(104, 186, 100)",
			text_color : "#000000",
			onChange:function(res) {
					var pageNum = res;
					location.href = getRootPath() + "/favorite!load?pageNum=" + pageNum;
				}
			}
		);
	});
</script>


<title>无标题文档</title>
</head>

<body>

<div id="hideprops" style="display: none;">
	<div id="rpagecount"><s:property value='rpageCount'/></div>
	<div id="rpagenum"><s:property value='rpageNum'/></div>
	<div id="rtotalcount"><s:property value='rtotalCount'/></div>
	<div id="rpagesize"><s:property value='rpagesize'/></div>
</div>

<table cellspacing="1" cellpadding="0" bgcolor="#1C80B7" width="98%" align="center" border="0" class="tablect" style="padding:3px">
<tbody>
 <tr bgcolor="#FFFFFF" >
 	<td colspan="5" class="head">收藏的试剂库</td>
 </tr>
 <tr bgcolor="#1C80B7">
 	<th width="15%">试剂库编号</th>
 	<th width="20%">试剂库名称</th>
 	<th width="20%">所属单位</th>
 	<th width="20%">创建人</th>
 	<th width="23%">操作</th>
 </tr>
 
 <s:iterator value="repos">
 <tr bgcolor="#FFFFFF">
 	<td width="15%"><s:property value="repository.repoNo"/></td>
 	<td width="20%">
 		<a href="<%=basePath %>/repository!showDetail?id=<s:property value='repository.id'/>">
 			<s:property value="repository.repoName"/>
 		</a>
 	</td>
 	<td width="20%"><s:property value="repository.department"/></td>
 	<td width="20%"><s:property value="user.username"/></td>
 	<td width="23%">
 		<a href="javascript:;" repo_id="<s:property value='repository.id'/>" del="ok">取消收藏</a>
 	</td>
 </tr>
 </s:iterator>
 
  <tr bgcolor="#FFFFFF">
 	<td colspan="5" >
 		<div id="mypage">
 			<div id="rpagination"></div>
 		</div>
 	</td>
 </tr>
 
<%--<tr bgcolor="#FFFFFF">
 	<td colspan="5" class="head">
 		收藏的试剂
 	</td>
 </tr>
 <tr bgcolor="#1C80B7">
 	<th width="15%">试剂图片</th>
 	<th width="20%">试剂名称</th>
 	<th width="20%">所属试剂库</th>
 	<th width="20%">创建人</th>
 	<th width="23%">操作</th>
 </tr>
 
 <s:iterator value="ms" var="repo">
 <tr bgcolor="#FFFFFF">
 	<td width="15%"><s:property value="#repo.repoNo"/></td>
 	<td width="20%">
 		<a href="<%=basePath %>/repository!showDetail?id=<s:property value='#repo.repoId'/>">
 			<s:property value="#repo.repoName"/>
 		</a>
 	</td>
 	<td width="20%"><s:property value="#repo.department"/></td>
 	<td width="20%"><s:property value="#repo.username"/></td>
 	<td width="23%">
 		<a href="javascript:;" repo_id="<s:property value='#repo.repoId'/>" del="ok">取消收藏</a>
 	</td>
 </tr>
 </s:iterator>
 
  <tr bgcolor="#FFFFFF">
 	<td colspan="5" >
 		<div id="mypage">
 			<div id="pagination"></div>
 		</div>
 	</td>
 </tr>
--%></tbody>
 </table>
</body>
</html>
