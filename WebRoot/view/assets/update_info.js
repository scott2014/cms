$(function() {
	info.submit();
	info.reset();
});


var info = {
	submit:function() {
		$("#sub").bind("click",function() {
			var qq = $("input[name='user.qq']").val();
			var phone = $("input[name='user.phone']").val();
			var email = $("input[name='user.email']").val();
			
			var re = /^[0-9,a-z,A-Z]+$/;
			
			if (email.trim() != "" && !re.test(email)) {
				$("#email_tip").html("不能包含特殊字符");
				return;
			}
			
			if (qq.trim() != "" && isNaN(qq) || parseInt(qq) < 10000 || parseInt(qq) > 9999999999) {
				$("#qq_tip").html("QQ号码为4到10位纯数字");
				return;
			}
			
			if (phone.trim() != "" && isNaN(phone) || phone.length != 11) {
				$("#phone_tip").html("必须为11位纯数字");
				return;
			}
			
			$("#form1").submit();
		});
	},
	reset : function() {
		$("#reset").bind("click",function() {
			$("input[type='text']").val("");
			$("textarea").val("");
			$("span").html("");
		});
	}
};