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
<script type="text/javascript" src="<%=basePath %>/view/assets/repository.js"></script>
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
					location.href = getRootPath() + "/repository!load?key=" + key + "&pageNum=" + pageNum;
				}
			}
		);
	});
</script>


<title>无标题文档</title>
</head>

<body>
<div id="search">
 	关键词:
 	<input name="keys" type="text" value="<s:property value='key'/>" size="30" />
    <input type="button" value="搜索试剂库" id="search_btn"/>
</div>

<div id="hideprops" style="display: none;">
	<div id="pagecount"><s:property value='pageCount'/></div>
	<div id="pagenum"><s:property value='pageNum'/></div>
	<div id="totalcount"><s:property value='totalCount'/></div>
	<div id="pagesize"><s:property value='pageSize'/></div>
</div>

<table cellspacing="1" cellpadding="0" bgcolor="#1C80B7" width="98%" align="center" border="0" style="padding:3px">
<tbody>
 <tr bgcolor="#1C80B7">
 	<th width="15%">试剂库编号</th>
 	<th width="20%">试剂库名称</th>
 	<th width="20%">所属单位</th>
 	<th width="15%">创建时间</th>
 	<th width="28%">操作</th>
 </tr>
 
 <s:iterator value="repos" var="repo" status="st">
  <tr 
	 <s:if test="#st.odd">
	 	bgcolor="#FFFFFF"
	 </s:if>
	 <s:else>
	 	bgcolor="#EEF7FF"
	 </s:else>
     desc="content"
 >
 	<td><s:property value="#repo.repoNo"/></td>
 	<td>
 		<a href="<%=basePath %>/repository!showDetail?id=<s:property value='#repo.repoId'/>">
 			<s:property value="#repo.repoName"/>
 		</a>
 	</td>
 	<td><s:property value="#repo.department"/></td>
 	<td><s:date name="#repo.createTime" format="yyyy-MM-dd HH:mm"/></td>
 	<td>
 		<s:if test="#repo.userId == #session.user.id">
 			 <a href="javascript:;" repo_id="<s:property value='#repo.repoId'/>" del="ok">删除</a>
 				  |
 			<a href="javascript:;" repo_id="<s:property value='#repo.repoId'/>" update="ok">修改</a>
 		</s:if>
 		<s:if test="#repo.stored == @com.cms.model.constant.RepositoryConst@NOT_STORED">
	 		<s:if test="#repo.userId != #session.user.id">
	 			<a href="javascript:;" repo_id="<s:property value='#repo.repoId'/>" save="ok">收藏</a>
	 		</s:if>
 		</s:if>
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
</tbody>
 </table>
</body>
</html>
