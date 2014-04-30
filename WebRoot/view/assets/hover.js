$(function() {
	index.hover();
	index.click();
});

var index = {
	hover : function() {
		$("li").hover(function() {
			$(this).addClass("hoverclass");
		},function(){
			$(this).removeClass("hoverclass");
		});
	},
	click : function() {
		$("li").bind("click",function() {
			$(this).attr("style","background-color:#BCD6EF;");
			$(this).attr("flag","true");
			
			var lis = $("li");
			var now = $(this);
			
			lis.each(function() {
				if($(this).attr("flag") == undefined && $(this).attr("style") != undefined) {
					$(this).removeAttr("style");
				};
				
			});
			now.removeAttr("flag");
		});
	}
};