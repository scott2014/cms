$(function() {
	repository.search();
	repository.del();
	repository.update();
	repository.save();
	repository.hover();
});

var repository = {
	search : function() {
		$("#search_btn").bind("click",function() {
			var keyWord = $("input[name='keys']").val();
			location.href = getRootPath() + "/repository!load?key=" + keyWord.trim();
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
	save : function() {
		$("a[save='ok']").bind("click",function() {
			var ok = window.confirm("确定加入收藏吗？");
			if (ok) {
				var repoId = $(this).attr("repo_id");
				$.ajax({
					url : getRootPath() + "/userajax/favorite",
					type : "post",
					cache : false,
					async : false,
					data : {repositoryId : repoId},
					dataType : "json" ,
					success : function(res) {
						alert(res.errorCode);
					}
				});
			}
	});
	},
	hover : function() {
		$("tr[desc='content']").hover(function(){
			$(this).addClass("hoverclass");
		},function() {
			$(this).removeClass("hoverclass");
		});
	}
};