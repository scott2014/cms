
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
<title>实验室管理系统</title>
<link href="index.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/hover.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/login.js"></script>

</head>

<body>

	<div id="main">

		<div id="top">
			实验室药品管理系统
			<div id="info">
				<s:iterator value="#session.user.rights">
					<s:if test="rightCode == @com.cms.model.constant.UserRight@ADMINISTRATOR">
						<s:set name="flag" value="1">
							
						</s:set>
					</s:if>
				</s:iterator>
				当前用户：<a href="<%=basePath %>/view/pages/my_info.jsp" target="main_frame"><s:property value="#session.user.username"/></a>
				权限：<s:if test="#flag == 1">管理员</s:if>
					<s:else>学生</s:else>
			</div>
		</div>

		<div id="leftBar">

			<div class="left_top">试剂库管理</div>
			<ul>
				<s:iterator value="#session.user.rights" var="right">
					<s:if
						test="#right.rightCode == @com.cms.model.constant.UserRight@ADMINISTRATOR">
						<s:set name="flag" value="1" />
					</s:if>
				</s:iterator>
				<s:if test="#flag == 1">
					<li style="background-color:#BCD6EF;"><a
						href="<%=basePath%>/repository!toCreate" target="main_frame">
							<img src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;创建试剂库 </a></li>
					<li><a href="<%=basePath%>/repository!myrepo"
						target="main_frame"> <img
							src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;我的试剂库 </a></li>
					<li><a href="<%=basePath%>/repository!load"
						target="main_frame"> <img
							src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;查找试剂库 </a></li>
				</s:if>
				<s:else>
					<li style="background-color:#BCD6EF;"><a
						href="<%=basePath%>/repository!load" target="main_frame"> <img
							src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;查找试剂库 </a></li>
				</s:else>


				<li><a href="<%=basePath%>/favorite!load" target="main_frame">
						<img src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;我的收藏 </a></li>

				<li><a href="<%=basePath%>/history!load" target="main_frame">
						<img src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;历史浏览 </a></li>
			</ul>
			<div id="shiji">
				<div class="left_top">试库管理</div>
				<div class="left_cont">
					<ul>
						<s:if test="#flag == 1">
							<li><a href="<%=basePath%>/medicinal!toCreate"
								target="main_frame"> <img
									src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;添加试剂 </a></li>

							<li><a href="<%=basePath%>/medicinal!loadMe"
								target="main_frame"> <img
									src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;试剂管理 </a></li>
							<li><a href="<%=basePath%>/userMedicinal!check" target="main_frame">
							 <img src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;请求审核</a></li>
						</s:if>


						<li><a href="<%=basePath%>/medicinal!load"
							target="main_frame"><img
								src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;查找试剂</a>
						</li>
						
						
						<s:if test="#flag != 1">
							<li><a href="<%=basePath%>/medicinal!myApply"
							target="main_frame"><img
								src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;我的申请</a>
							</li>
							<li><a href="<%=basePath%>/medicinal!tgApply"
								target="main_frame"><img
									src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;审核通过</a>
							</li>
							<li><a href="<%=basePath%>/medicinal!rfApply"
								target="main_frame"><img
									src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;审核拒绝</a>
							</li>
							<li><a href="<%=basePath%>/medicinal!appliedMedicinal"
								target="main_frame"><img
									src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;我的试剂</a>
							</li>
						</s:if>
					</ul>
				</div>
			</div>

			<div id="setting">
				<div class="left_top">系统设置</div>
				<div class="left_cont">
					<ul>
						<li><a href="<%=basePath %>/view/pages/my_info.jsp" target="main_frame"><img
								src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;个人信息</a>
						</li>
						<li><a href="<%=basePath %>/view/pages/update_pass.jsp" target="main_frame"><img
								src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;修改密码</a>
						</li>
						<s:if test="#flag == 1">
							<li>
								<a href="<%=basePath %>/user!mgr" target="main_frame">
									<img src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;账户管理
								</a>
							</li>
						</s:if>
						<li><a href="javascript:;" id="loginOut"><img
								src="<%=basePath%>/view/pages/icon1.gif" />&nbsp;退出系统</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<!--右侧内容页-->
		<div id="main_frame">
			<s:iterator value="#session.user.rights">
				<s:if
					test="rightCode == @com.cms.model.constant.UserRight@ADMINISTRATOR">
					<s:set name="flag" value="1" />
				</s:if>
			</s:iterator>
			<s:if test="#flag == 1">
				<iframe name="main_frame" width="100%" height="100%"
					scrolling="auto" marginwidth="0" framespacing="0" marginheight="0"
					frameborder="0" src="create_repo.jsp" />
			</s:if>
			<s:else>
				<iframe name="main_frame" width="100%" height="100%"
					scrolling="auto" marginwidth="0" framespacing="0" marginheight="0"
					frameborder="0" src="find_repo.jsp" />
			</s:else>
		</div>
	</div>
</body>
</html>
