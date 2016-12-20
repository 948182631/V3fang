function fangAjaxDataTable(type,url,async,Grid,DataTableid) {
	$.ajax({
		type: type,
		url : url,
		async: async,
		success : function(data) {
		if(data!=null){
			var obj = jQuery.parseJSON(data);
			 $("#"+Grid).append(obj.table);
			}else{
				layer.msg("异常！返回为空",{icon:2,time:1200});  
			}
		},error : function() {  
			layer.msg("异常！",{icon:2,time:1200});  
		}  
	});
	$("#"+DataTableid).DataTable().draw( false );
}