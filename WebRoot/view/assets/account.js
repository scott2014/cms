$(function() {
	account.operator();
	account.del();
});

var account = {
	operator : function() {
		$("a[update='ok']").live("click",function() {
			
			var str = $(this).html().trim();
			if (str == "冻结") {
				var ok = window.confirm("确认冻结该账户吗？");
				
				if (ok) {
					var userId = $(this).attr("user_id");
					
					var a = $(this);
					
					$.ajax({
						url : getRootPath() + "/userajax/user!freeze",
						type : "post",
						cache : false,
						async : false,
						data : {id : userId},
						dataType : "json",
						success : function(res) {
							a.html("解冻");
						}
					});
				}
			}
			if (str == "解冻") {
				var ok = window.confirm("确认冻结该账户吗？");
				
				if (ok) {
					var userId = $(this).attr("user_id");
					
					var a = $(this);
				
					$.ajax({
						url : getRootPath() + "/userajax/user!release",
						type : "post",
						cache : false,
						async : false,
						data : {id : userId},
						dataType : "json",
						success : function(res) {
							a.html("冻结");
						}
					});
				}
			}
			
			
		});
	},
	del : function() {
		$("a[del='ok']").bind("click",function() {
			var ok = window.confirm("确认冻结该账户吗？");
			
			if (ok) {
				var userId = $(this).attr("user_id");
				
				var parentTr = $(this).parent().parent();
				
				$.ajax({
					url : getRootPath() + "/userajax/user!delete",
					type : "post",
					cache : false,
					async : false,
					data : {id : userId},
					dataType : "json",
					success : function(res) {
						parentTr.hide();
					}
				});
			}
		});
	}
};