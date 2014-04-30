$(function() {
	shiji.search();
});

var shiji = {
	search : function() {
		$("#search_btn").bind("click",function() {
			var keyWord = $("input[name='keys']").val();
			location.href = getRootPath() + "/medicinal!load?key=" + keyWord.trim();
		});
	}
};