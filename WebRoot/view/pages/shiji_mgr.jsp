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
<script type="text/javascript" src="<%=basePath %>/view/assets/shiji_mgr.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/jPaginate/jquery.paginate.js"></script>

<script type="text/javascript">
	$(function() {
		$("#pagination").paginate({
			count : parseInt($("#pagecount").html().trim()),
			start : parseInt($("#pagenum").html().trim()),
			display : parseInt($("#pagesize").html().trim()),
			border : true,
			background_color : "#1C80B7",
			text_hover_color : "#000",
			background_hover_color : "rgb(104, 186, 100)",
			text_color : "#000000",
			onChange:function(res) {
					var key = $("input[name=keys]").val();
					var pageNum = res;
					var params = {key : key,pageNum:pageNum};
					location.href = getRootPath() + "/medicinal!loadMe?key=" + key + "&pageNum=" + pageNum;
				}
			}
		);
	});
</script>


<title>无标题文档</title>
</head>

<body>
<div id="hideprops" style="display: none;">
	<div id="pagecount"><s:property value='pageCount'/></div>
	<div id="pagenum"><s:property value='pageNum'/></div>
	<div id="totalcount"><s:property value='totalCount'/></div>
	<div id="pagesize"><s:property value='totalCount'/></div>
</div>

<table cellspacing="1" cellpadding="0" bgcolor="#1C80B7" width="98%" align="center" border="0" class="tablect" style="padding:3px">
<tbody>
 <tr bgcolor="#1C80B7">
 	<th width="15%">试剂 图片</th>
 	<th width="20%">试剂名称</th>
 	<th width="20%">所属试剂库</th>
 	<th width="23%">操作</th>
 </tr>
 
 <s:iterator value="myme">
 <tr bgcolor="#FFFFFF">
 	<td>
		<a href="<%=basePath %>/medicinal!toDetail?id=<s:property value='medicinal.id'/>">
			<img src="<%=basePath %>/<s:property value='medicinal.photo' />" alt="" />
		</a>
	</td>
 	<td width="20%">
 		<a href="<%=basePath %>/medicinal!toDetail?id=<s:property value='medicinal.id'/>">
 			<s:property value="medicinal.name"/>
 		</a>
 	</td>
 	<td width="20%">
 		<select name="repositoryId">
 			<s:iterator value="myrepos">
 				<s:if test="repository.id == id">
 					<option value="<s:property value='id'/>" selected="selected"><s:property value='repoName'/></option>
 				</s:if>
 				<s:else>
 					 <option value="<s:property value='id'/>"><s:property value='repoName'/></option>
 				</s:else>
 			</s:iterator>
 		</select>
 	<s:property value="#repo.department"/></td>
 	<td width="20%">
 		<a href="javascript:;" del="ok" mid=<s:property value='medicinal.id'/>>删除</a> | <a href="javascript:;" update="ok" mid=<s:property value='medicinal.id'/>>修改</a>
 	</td>
 </tr>
 </s:iterator>
 
 <s:if test="totalCount > 0">
  <tr bgcolor="#FFFFFF">
 	<td colspan="5" >
 		<div id="mypage">
 			<div id="pagination"></div>
 		</div>
 	</td>
 </tr>
 </s:if>
</tbody>
 </table>
</body>
</html>
