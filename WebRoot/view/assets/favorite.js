$(function() {
	favorite.cancel();
});

var favorite = {
	cancel : function() {
		$("a[del='ok']").bind("click",function() {
			var ok = window.confirm("从收藏列表中移除吗？");
			var parentTr = $(this).parent().parent();
			if (ok) {
				var repoId = $(this).attr("repo_id");
				$.ajax({
					url : getRootPath() + "/userajax/favorite!delete",
					type : "post",
					cache : false,
					async : false,
					data : {id : repoId},
					dataType : "json" ,
					success : function(res) {
						parentTr.hide();
						alert("已从收藏中移除");
					}
				});
			}
	});
	}
};