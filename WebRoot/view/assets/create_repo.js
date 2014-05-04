$(function() {
	repo.check();
	repo.reset();
});

var repo = {
	check : function() {
		$("#tijiao").bind("click",function() {
			var repoNo = $("input[name='repository.repoNo']").val();
			var repoName = $("input[name='repository.repoName']").val();
			var department = $("input[name='repository.department']").val();
			var address = $("input[name='repository.address']").val();
			var university = $("input[name='repository.university']").val();
			var faculty = $("input[name='repository.faculty']").val();
			var team = $("input[name='repository.team']").val();
			var advice = $("textarea[name='repository.advice']").html();

			
			if (repoNo == null || repoNo.trim() == "") {
				$("#tip_repoNo").html("*请输入试剂库编号(长度小于16)");
				$("input[name='repository.repoNo']").focus();
				return;
			} else {
				$("#tip_repoNo").html("");
			}
			
			if (repoNo.trim().length > 16) {
				$("#tip_repoNo").html("*请输入正确的试剂库编号(长度小于16)");
				$("input[name='repository.repoNo']").focus();
				return;
			} else {
				$("#tip_repoNo").html("");
			}
			
			if (repoName == null || repoName.trim() == "") {
				$("#tip_repoName").html("*请输入试剂库名称");
				$("input[name='repository.repoName']").focus();
				return;
			} else {
				$("#tip_repoName").html("");
			}
			
			if (university == null || university.trim() == "") {
				$("#tip_university").html("*请输入试剂库所在单位名称");
				$("input[name='repository.university']").focus();
				return;
			} else {
				$("#tip_university").html("");
			}
			
			if (department == null || department.trim() == "") {
				$("#tip_department").html("*请输入试剂库所在学院名称");
				$("input[name='repository.department']").focus();
				return;
			} else {
				$("#tip_department").html("");
			}
			
			if (faculty == null || faculty.trim() == "") {
				$("#tip_faculty").html("*请输入试剂库所在系名称");
				$("input[name='repository.faculty']").focus();
				return;
			} else {
				$("#tip_faculty").html("");
			}
			
			if (team == null || team.trim() == "") {
				$("#tip_team").html("*请输入试剂库所在团队名称");
				$("input[name='repository.team']").focus();
				return;
			} else {
				$("#tip_team").html("");
			}
			
			if (address == null || address.trim() == "") {
				$("#tip_address").html("*请输入试剂库存放地点");
				$("input[name='repository.address']").focus();
				return;
			} else {
				$("#tip_address").html("");
			}
			
			if (fields == null || fields.trim() == "") {
				$("#tip_fields").html("*请输入试剂库属性");
				$("input[name='repository.fields']").focus();
				return;
			} else {
				$("#tip_fields").html("");
			}
			
			if (advice == null || advice.trim() == "") {
				$("#tip_advice").html("*请输入你的建议");
				$("textarea[name='repository.advice']").focus();
				return;
			} else {
				$("#tip_advice").html("");
			}
			
			repo.tijiao();
		});
	},
	tijiao : function() {
		$("#form").submit();
	},
	reset : function() {
		$("#reset").bind("click",function() {
			$("input[name='repository.repoNo']").val("");
			$("input[name='repository.repoName']").val("");
			$("input[name='repository.department']").val("");
			$("input[name='repository.address']").val("");
			$("input[name='repository.university']").val("");
			$("input[name='repository.faculty']").val("");
			$("input[name='repository.team']").val("");
			$("textarea[name='repository.advice']").html("");
			
			
			$("#tip_repoNo").html("");
		    $("#tip_repoName").html("");
			$("#tip_address").html("");
			$("#tip_department").html("");
			$("#tip_university").html("");
			$("#tip_faculty").html("");
			$("#tip_team").html("");
			$("#tip_advice").html("");

			
			$("input[name='repository.repoNo']").focus();
		});
	}
};