$(function() {
	history.hover();
});

var history = {
	hover : function() {
		$("tr[desc='content']").hover(function() {
			$(this).addClass("hoverclass");
		},function() {
			$(this).removeClass("hoverclass");
		});
	}
};