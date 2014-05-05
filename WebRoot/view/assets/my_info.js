$(function() {
	info.toUpdate();
});

var info = {
	toUpdate : function() {
		$("input[type='button']").bind("click",function() {
			location.href = getRootPath() + "/user!toUpdateInfo";
		});
	}
};