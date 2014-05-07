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
				alert("申请试剂数量超过总量");
				return;
			}
			
			$("#form1").submit();
		});
	}
};