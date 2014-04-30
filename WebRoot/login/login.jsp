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
<title>实验室药品管理系统</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>/view/pages/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/login.js"></script>

</head>

<body>
	<div id="login">
    	<div id="login_frame">
	    	<div id="login_top" >
    	    	实验室药品管理系统
        	</div>
        	<div id="login_input">
        		<form action="<%=basePath %>/user!login" method="post" id="login_form">
        	<table>
            	<tr>
                	<td align="right" width="13%">用户名：</td>
                    <td align="left" width="30%">
                  	  <input type="text" name="username" id="username"/>
					</td>
					<td class="tip" id="username_tip" width="20%">
						<span></span>
					</td>
                </tr>
                <tr>
                	<td align="right">密码：</td>
                    <td align="left">
                    <input type="password" name="password" id="password"/>
					</td>
					<td class="tip" id="password_tip">
						<span><s:property value="errorCode"/></span>
					</td>
                </tr>
                <tr id="login_btn">
                	<td colspan="3" >
						<input type="button" value="登录" class="btn" id="login"/>&nbsp;&nbsp;
                        <a href="javascript:;" id="reg">注册</a>
					</td>
                </tr>
            </table>
            </form>
        	</div>
        </div>
    </div>
</body>
</html>
