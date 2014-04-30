$(function() {
	register.check();
	register.toLogin();
});

var register = {
	check : function() {
		$("#register").bind("click",function() {
			var username = $("input[name='username']").val();
			var password = $("input[name='password']").val();
			var password2 = $("input[name='password2']").val();
			
			if (username.trim() == "") {
				$("#username_tip span").html("*请输入用户名");
				$("#username").focus();
				return;
			} else {
				$("#username_tip span").html("");
			}
			
			if (password == "") {
				$("#password_tip span").html("*请输入密码");
				$("#password").focus();
				return;
			} else {
				$("#password_tip span").html("");
			}
			
			if (password == "") {
				$("#password2_tip span").html("*请输入确认密码");
				$("#password2").focus();
				return;
			} else {
				$("#password2_tip span").html("");
			}
			
			if (password != password2) {
				$("#password2_tip span").html("*两次密码输入不一致");
				$("#password2").focus();
				return;
			} else {
				$("#password2_tip span").html("")
			}
			
			//全部通过校验，提交一个ajax请求验证用户是否存在
			$.ajax({
				url : getRootPath() + "/userajax/user!check",
				type : "post",
				cache : false,
				async : false,
				data : {username : username},
				dataType : "json",
				success : function(res) {
					var isExist = res.exist;
					if (!isExist) {
						register.reg();
					} else {
						$("#username_tip span").html("*该用户已经存在");
					}
				}
			});
		});
	},
	reg : function () {
		$("#register_form").submit();
		alert("注册成功");
	},
	toLogin : function() {
		$("#to_login").bind("click",function() {
			location.href = getRootPath() + "/login/login.jsp";
		});
	}
};