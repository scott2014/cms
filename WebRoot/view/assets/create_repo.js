$(function() {
	repo.check();
	repo.reset();
});

var repo = {
	check : function() {
		$("#tijiao").bind("click",function() {
			var repoNo = $("input[name='repositoryVO.repoNo']").val();
			var repoName = $("input[name='repositoryVO.repoName']").val();
			var department = $("input[name='repositoryVO.department']").val();
			var address = $("input[name='repositoryVO.address']").val();
			var email = $("input[name='repositoryVO.email']").val();
			var phone = $("input[name='repositoryVO.phone']").val();
			var qq = $("input[name='repositoryVO.qq']").val();
			
			if (repoNo == null || repoNo.trim() == "") {
				$("#tip_repoNo").html("*请输入试剂库编号(长度小于16)");
				$("input[name='repositoryVO.repoNo']").focus();
				return;
			} else {
				$("#tip_repoNo").html("");
			}
			
			if (repoNo.trim().length > 16) {
				$("#tip_repoNo").html("*请输入正确的试剂库编号(长度小于16)");
				$("input[name='repositoryVO.repoNo']").focus();
				return;
			} else {
				$("#tip_repoNo").html("");
			}
			
			if (repoName == null || repoName.trim() == "") {
				$("#tip_repoName").html("*请输入试剂库名称");
				$("input[name='repositoryVO.repoName']").focus();
				return;
			} else {
				$("#tip_repoName").html("");
			}
			
			if (department == null || department.trim() == "") {
				$("#tip_department").html("*请输入试剂库所在部门名称");
				$("input[name='repositoryVO.department']").focus();
				return;
			} else {
				$("#tip_department").html("");
			}
			
			if (address == null || address.trim() == "") {
				$("#tip_address").html("*请输入试剂库常用存放地点(多个用逗号隔开)");
				$("input[name='repositoryVO.address']").focus();
				return;
			} else {
				$("#tip_address").html("");
			}
			
			if (email == null || email.trim() == "") {
				$("#tip_email").html("*请输入你的邮箱地址");
				$("input[name='repositoryVO.email']").focus();
				return;
			} else {
				$("#tip_email").html("");
			}
			
			if (email.indexOf("@") < 0 || email.indexOf("@") >= email.length - 1) {
				$("#tip_email").html("*邮箱地址不正确");
				$("input[name='repositoryVO.email']").focus();
				return;
			} else {
				$("#tip_email").html("");
			}
			
			if (phone == null || phone.trim() == "") {
				$("#tip_phone").html("*请输入你的手机号码(11位数字)");
				$("input[name='repositoryVO.phone']").focus();
				return;
			} else {
				$("#tip_phone").html("");
			}
			
			if (phone.length != 11 || isNaN(phone)) {
				$("#tip_phone").html("*你的手机号码输入有误(11位数字)");
				$("input[name='repositoryVO.phone']").focus();
				return;
			} else {
				$("#tip_phone").html("");
			}
			
			if (qq == null || qq.trim() == "") {
				$("#tip_qq").html("*请输入你的QQ号码(5-11位数字)");
				$("input[name='repositoryVO.qq']").focus();
				return;
			} else {
				$("#tip_qq").html("");
			}
			
			if (qq.length > 11 || qq.length < 5 || isNaN(qq)) {
				$("#tip_qq").html("*你的qq号码输入有误(5-11为数字)");
				$("input[name='repositoryVO.qq']").focus();
				return;
			} else {
				$("#tip_qq").html("");
			}
			
			repo.tijiao();
		});
	},
	tijiao : function() {
		$("#form").submit();
	},
	reset : function() {
		$("#reset").bind("click",function() {
			$("input[name='repositoryVO.repoNo']").val("");
			$("input[name='repositoryVO.repoName']").val("");
			$("input[name='repositoryVO.department']").val("");
			$("input[name='repositoryVO.address']").val("");
			$("input[name='repositoryVO.email']").val("");
			$("input[name='repositoryVO.phone']").val("");
			$("input[name='repositoryVO.qq']").val("");
			
			
			$("#tip_repoNo").html("");
		    $("#tip_repoName").html("");
			$("#tip_address").html("");
			$("#tip_email").html("");
			$("#tip_phone").html("");
			$("#tip_qq").html("");
			$("#tip_department").html("");
			
			$("input[name='repositoryVO.repoNo']").focus();
		});
	}
};