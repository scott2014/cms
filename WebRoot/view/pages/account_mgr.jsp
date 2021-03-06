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
<script type="text/javascript" src="<%=basePath %>/view/assets/account.js"></script>
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
					var pageNum = res;
					location.href = getRootPath() + "/user!mgr?&pageNum=" + pageNum;
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
	<div id="pagesize"><s:property value='pageSize'/></div>
</div>

<table cellspacing="1" cellpadding="0" bgcolor="#1C80B7" width="98%" align="center" border="0" class="tablect" style="padding:3px">
<tbody>
  <tr bgcolor="#1C80B7">
	  <th width="15%">账号</th>
	  <th width="20%">真实姓名</th>
	  <th width="25%">注册日期</th>
	  <th width="25%">最近一次登录</th>
	  <th width="40%">操作</th>
  </tr>

 <s:iterator value="users" status="st">
   <tr  <s:if test="#st.odd">
	 	bgcolor="#FFFFFF"
	 </s:if>
	 <s:else>
	 	bgcolor="#EEF7FF"
	 </s:else>
     desc="content">
	  <td width="15%">
	  	<a href="<%=basePath %>/user!showInfo?id=<s:property value='id'/>">
	  		<s:property value='username'/>
	  	</a>
	  </td>
	  <td width="20%">
 		<a href="<%=basePath %>/user!showInfo?id=<s:property value='id'/>">
 			<s:property value="realName"/>
 		</a>
 	  </td>
 	  <td width="20%">
			<s:date name="registerTime" format="yyyy-MM-dd HH:mm"/>
 	  </td>
 	  <td width="20%">
			<s:date name="lastLogin" format="yyyy-MM-dd HH:mm"/>
 	  </td>
  	  <td width="23%">
 		<a href="javascript:;" user_id="<s:property value='id'/>" del="ok">删除</a>
 			|
 		<a href="javascript:;" user_id="<s:property value='id'/>" update="ok">
 			<s:if test="status == @com.cms.model.constant.Account@FREEZE">解冻</s:if>
 			<s:else>冻结</s:else>
 		</a>
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
