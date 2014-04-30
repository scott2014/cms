$(function() {
	shiji.del();
	shiji.update();
	shiji.search();
});

var shiji = {
	search : function() {
		$("#search_btn").bind("click",function() {
			var keyWord = $("input[name='keys']").val();
			location.href = getRootPath() + "/medicinal!loadMe?key=" + keyWord.trim();
		});
	},
	del : function() {
		$("a[del='ok']").bind("click",function() {
			var mId = $(this).attr("mid");
			var ok = window.confirm("确认删除吗？");
			var params = {mId : mId};
			
			var parentTr = $(this).parent().parent();
			
			if (ok) {
				$.ajax({
					url : getRootPath() + "/userajax/medicinal!delete",
					type : "post",
					cache : false,
					async : false,
					data : params,
					dataType : "json",
					success : function(res) {
						parentTr.hide();
					}
				});
			}
		});
	},
	update : function() {
		$("a[update='ok']").bind("click",function() {
			var mid = $(this).attr("mid");
			location.href = getRootPath() + "/medicinal!toUpdate?id=" + mid;
		});
	}
};