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
<link href="login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>/view/assets/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/base.js"></script>
<script type="text/javascript" src="<%=basePath %>/view/assets/register.js"></script>

<title>实验室药品管理系统</title>
</head>

<body>
	<div id="login">
    	<div id="login_frame">
    		<div id="login_top" >
    	    	实验室药品管理系统
        	</div>
        	<div id="login_input">
    		<form action="<%=basePath %>/user!register" method="post" id="register_form">
        	<table border="0">
            	<tr>
                	<td align="right" width="18%">用户名：</td>
                    <td align="left" width="39%">
                    <input type="text" name="username"/>
					</td>
					<td class="tip" id="username_tip" align="left" width="30%">
					  <span></span>
					</td>
                </tr>
                <tr>
                	<td>用户密码：</td>
                    <td>
                    <input type="password" name="password"/>
					</td>
					<td class="tip" id="password_tip">
						 <span></span>
					</td>
                </tr>
				<tr>
                	<td>密码确认：</td>
                    <td>
                    <input type="password" name="password2"/>
					</td>
					<td class="tip" id="password2_tip">
						<span></span>
					</td>
                </tr>
                <tr id="login_btn">
                	<td colspan="3" >
						<input type="button" value="确认注册" class="btn" id="register"/>&nbsp;&nbsp;
                        <a href="javascript:;" id="to_login">直接登录</a>
					</td>
                </tr>
            </table>
            </form>
            </div>
        </div>
    </div>
</body>
</html>
