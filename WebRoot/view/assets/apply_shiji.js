$(function() {
	shiji.apply();
});

var shiji = {
	apply : function() {
		$("#apply").bind("click",function() {
			var number = $("input[name='applyNumber']").val();
			var total = $("#left_td").html().trim();
			
			if (number == undefined || number.trim() == "") {
				alert("请输入所需药品剂量！");
				return;
			}
			
			if (isNaN(number)) {
				alert("请输入正确的数字！");
				return;
			}
			
			if (parseInt(number) > parseInt(total)) {
				var ok = window.confirm("试剂总量不足，是否建议管理员添加");
				if (ok) {
					$("#form1").submit();
				}
				return;
			}
			
			$("#form1").submit();
		});
	}
};