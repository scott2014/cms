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
<script type="text/javascript" src="<%=basePath %>/view/assets/myrepo.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/jPaginate/jquery.paginate.js"></script>

<script type="text/javascript">
	$(function() {
		$("#pagination").paginate({
			count : parseInt($("#pagecount").html().trim()),
			start : parseInt($("#pagenum").html().trim()),
			display : parseInt($("#pagesize").html().trim()),
			border : true,
			background_color : "rgb(0, 204, 255)",
			text_hover_color : "#000",
			background_hover_color : "rgb(104, 186, 100)",
			text_color : "#000000",
			onChange:function(res) {
					var key = $("input[name=keys]").val();
					var pageNum = res;
					var params = {key : key,pageNum:pageNum};
					location.href = getRootPath() + "/repository!myrepo?key=" + key + "&pageNum=" + pageNum;
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
	<div id="pagesize"><s:property value='totalCount'/></div>
</div>

<table cellspacing="1" cellpadding="0" bgcolor="#1C80B7" width="98%" align="center" border="0" class="tablect" style="padding:3px">
<tbody>
  <tr bgcolor="#1C80B7">
	  <th width="15%">试剂库编号</th>
	  <th width="20%">试剂库名称</th>
	  <th width="20%">所在单位</th>
	   <th width="20%">创建时间</th>
	  <th width="25%">操作</th>
  </tr>

 <s:iterator value="myrepos" status="st">
   <tr  <s:if test="#st.odd">
	 	bgcolor="#FFFFFF"
	 </s:if>
	 <s:else>
	 	bgcolor="#EEF7FF"
	 </s:else>
     desc="content">
	  <td><s:property value='repoNo'/></td>
	  <td>
 		<a href="<%=basePath %>/repository!showDetail?id=<s:property value='id'/>">
 			<s:property value="repoName"/>
 		</a>
 	  </td>
	  <td><s:property value='university'/></td>
	  <td><s:date name="createTime" format="yyyy-MM-dd HH:mm"/></td>
	  	<td>
 		<a href="javascript:;" repo_id="<s:property value='id'/>" del="ok">删除</a>
 			&nbsp;|&nbsp;
 		<a href="javascript:;" repo_id="<s:property value='id'/>" update="ok">修改</a>
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
