$(function() {
	pass.update();
});

var pass = {
	update : function() {
		$("#tijiao").bind("click",function() {
			var oldPass = $("input[name='oldPass']").val();
			var newPass = $("input[name='newPass']").val();
			var confirmPass = $("input[name='confirmPass']").val();
			var id = $("input[type='hidden']").val();

			if (oldPass == null || oldPass.trim() == "") {
				$("#tip_oldPass").html("*请输入原密码");
				return;
			} else {
				$("#tip_oldPass").html("");
			}
			
			if (newPass == null || newPass.trim() == "") {
				$("#tip_newPass").html("*请输入新密码");
				return;
			} else {
				$("#tip_newPass").html("");
			}
			
			if (confirmPass == null || confirmPass.trim() == "") {
				$("#tip_confirmPass").html("*再次输入新密码");
				return;
			} else {
				$("#tip_confirmPass").html("");
			}
			
			if (confirmPass != newPass) {
				$("#tip_confirmPass").html("*两次密码输入不一致");
				return;
			} else {
				$("#tip_confirmPass").html("");
			}
			
			$.ajax({
				url : getRootPath() + "/userajax/user!updatePass",
				cache : false,
				async : false,
				type : "post",
				data : {oldPass : oldPass,newPass : newPass,id : id},
				dataType : "json",
				success : function(res) {
					if (res.errorCode = "密码修改成功") {
						alert(res.errorCode);
					} else {
						$("#tip_oldPass").html(res.errorCode);
					}
				}
			});
		});
	},
	reset : function() {
		$("#reset").bind("click",function() {
			$("input[name='oldPass']").val("");
			$("input[name='newPass']").val("");
			$("input[name='confirmPass']").val("");

			$("#tip_oldPass").html("");
			$("#tip_newPass").html("");
			$("#tip_confirmPass").html("");
		});
	}
};