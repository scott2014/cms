$(function() {
	shiji.create();
});

var shiji = {
	create : function() {
		$("#tijiao").bind("click",function() {
			var left = $("input[name='medicinal.left']").val();
			
			if (left == undefined || left.trim() == "") {
				$("#tip_left").attr("style","color : red");
				$("#tip_left").html("*试剂数量不能为空");
				$("input[name='medicinal.left']").focus();
				return;
			} else {
				$("#tip_left").html("");
			}
			
			if (isNaN(left) || left <= 0) {
				$("#tip_left").attr("style","color : red");
				$("#tip_left").html("*输入正确的数字");
				$("input[name='medicinal.left']").focus();
				return;
			} else {
				$("#tip_left").html("");
			}
			$("#form1").submit();
		});
	}
};