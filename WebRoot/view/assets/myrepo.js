$(function() {
	myrepo.search();
	myrepo.del();
	myrepo.update();
	myrepo.hover();
});

var myrepo = {
		search : function() {
			$("#search_btn").bind("click",function() {
				var keyWord = $("input[name='keys']").val();
				location.href = getRootPath() + "/repository!myrepo?key=" + keyWord.trim();
			});
		},
		del : function() {
			$("a[del='ok']").bind("click",function() {
				var repoId = $(this).attr("repo_id");
				var ok = window.confirm("确认删除吗？");
				var params = {id : repoId};
				
				var parentTr = $(this).parent().parent();
				
				if (ok) {
					$.ajax({
						url : getRootPath() + "/userajax/repository!delete",
						type : "post",
						cache : false,
						async : false,
						data : params,
						dataType : "json",
						success : function(res) {
							var result = res.ok;
							if (result) {
								parentTr.hide();
							} else {
								alert("删除失败");
							}
						}
					});
				}
			});
		},
		update : function() {
			$("a[update='ok']").bind("click",function() {
				var repoId = $(this).attr("repo_id");
				location.href = getRootPath() + "/repository!loadById?id=" + repoId;
			});
		},
		hover : function() {
			$("tr[desc='content']").hover(function() {
				$(this).addClass("hoverclass");
			},function() {
				$(this).removeClass("hoverclass");
			});
		}
};