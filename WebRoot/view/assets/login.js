$(function() {
	login.toRegister();
	login.login();
	login.bindKeyDown();
	login.loginOut();
});


var login = {
	toRegister : function() {
		$("#reg").bind("click",function() {
			location.href = getRootPath() + "/view/pages/register.jsp";
		});
	},
	login : function() {
		$(".btn").bind("click",function() {
			var username = $("#username").val();
			var password = $("#password").val();
			
			$("#username_tip span").html("");
			$("#password_tip span").html("");
			
			if (username.trim() == "") {
				$("#username_tip span").html("*请输入用户名");
				return;
			} else {
				$("#username_tip span").html("");
			}
			
			if (password.trim() == "") {
				$("#password_tip span").html("*请输入用户密码");
				return;
			} else {
				$("#password_tip span").html("");
			}
			
			login.tijiao();
		});
		
		$("#username").bind("input propertychange",function() {
			if ($(this).val().trim() != "") {
				$("#username_tip span").html("");
			}
		});
		
		$("#password").bind("input propertychange",function() {
			if ($(this).val().trim() != "") {
				$("#password_tip span").html("");
			}
		});
	},
	tijiao : function() {
		var username = $("#username").val();
		var password = $("#password").val();
		
		var params = {username : username,password : password};
		
		$.ajax({
			url : getRootPath() + "/userajax/user!login",
			type : "post",
			cache : false,
			async : false,
			data : params,
			dataType : "json",
			success : function(res) {
				if (res.errorCode == "" || res.errorCode == null) {
					location.href = getRootPath() + "/view/pages/index.jsp";
				} else {
					$("#password_tip span").html(res.errorCode);
				}
			}
		});
	},
	bindKeyDown : function() {
		$(document).bind("keydown",function(event) {
			if (event.which == 13) {
				var username = $("#username").val();
				var password = $("#password").val();
				
				$("#username_tip span").html("");
				$("#password_tip span").html("");
				
				if (username.trim() == "") {
					$("#username_tip span").html("*请输入用户名");
					return;
				} else {
					$("#username_tip span").html("");
				}
				
				if (password.trim() == "") {
					$("#password_tip span").html("*请输入用户密码");
					return;
				} else {
					$("#password_tip span").html("");
				}
				
				login.tijiao();
			}
		});
	},
	loginOut : function() {
		$("#loginOut").bind("click",function() {
			var ok = window.confirm("确定退出系统吗？");
			if (ok) {
				location.href = getRootPath() + "/user!loginOut";
			}
		});
	}
};