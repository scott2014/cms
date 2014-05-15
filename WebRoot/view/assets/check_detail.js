$(function() {
	checkDetail.submit();
});


var checkDetail = {
	submit : function() {
		$("#sub").bind("click",function() {
			var id = $("input[name='id']").val();
			var status = $("input[name='status']:checked").val();
			
			var params = {id : id,status : status};
			$.ajax({
				url : getRootPath() + "/userajax/userMedicinal!update",
				type : "post",
				cache : false,
				async : false,
				data : params,
				dataType : 'json',
				success : function(res) {
					var errorCode = res.errorCode;
					
					if (errorCode == "") {
						location.href = getRootPath() + "/userMedicinal!check";
					} else {
						alert(errorCode);
					}
				},
			   error : function(XMLHttpRequest, textStatus, errorThrown) {
				   alert("网络连接异常，错误码：" + textStatus);
			   }
			});
		});
	}
};