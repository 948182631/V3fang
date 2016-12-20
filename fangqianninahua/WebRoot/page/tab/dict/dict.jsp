<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>  
	<head>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport"
			content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link href="<%=basePath%>H/css/H-ui.min.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>H/css/H-ui.admin.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>H/css/style.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=basePath%>H/lib/Hui-iconfont/1.0.1/iconfont.css"
			rel="stylesheet" type="text/css" />
			
		<script type="text/javascript"
			src="<%=basePath%>H/lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>H/lib/layer/1.9.3/layer.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>H/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>H/lib/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePath%>H/js/H-ui.js"></script>
		<script type="text/javascript" src="<%=basePath%>H/js/H-ui.admin.js"></script>
		<script type="text/javascript" src="<%=basePath%>H/js/fang.js"></script>
		<script type="text/javascript" src="<%=basePath%>H/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
			
			
			<script type="text/javascript" src="<%=basePath%>H/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
			<script type="text/javascript" src="<%=basePath%>H/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
	
		
			
			
		<script type="text/javascript">
		
		
		
$(function() {

fangAjaxDataTable("POST","/sys/dict.json",false,"dictGrid","dict_table");
});


function sdataTable() {
	
	 
		
}
function tr(id) {

layer.msg("tr"+id);

	
}
function del(id) {
	layer.confirm('确认要删除吗？',function(index){
	var	dicttype = $("#dicttype").val();
	var	dictname =$("#dictname").val();
	var table = $('#dict_table').DataTable();
	if ( $("#"+id+"TB").hasClass('selected') ) {
        $("#"+id+"TB").removeClass('selected');
    }
    else {
        table.$('tr.selected').removeClass('selected');
        $("#"+id+"TB").addClass('selected');
    }
	$.ajax({
		type:'POST',
		url : "/sys/dictdelete.json?id="+id,
		success : function(data) {
		if(data!=null){
				if(data==0){
						
						var currentPage = $("#dictactive").html();

						table.row('.selected').remove().draw( false );

					 	layer.msg('已删除!',{icon:1,time:1200});
					}else{
						layer.msg("删除失败",{icon:2,time:1200});  
						}
			}else{
				layer.msg("异常！返回为空",{icon:2,time:1200});  
			}
		},error : function() {  
			layer.msg("异常！",{icon:2,time:1200});  
		}  
	});
	 });
}
function update(id) {

	$.ajax({
		type:'POST',
		url : "/sys/qryDictbyid.json?id="+id,
		success : function(data) {
			if(data!=""){
					layer.msg(data);
				}else{
					layer.msg("异常！返回为空",{icon:2,time:1200});  
				}
		},error : function() {  
			layer.msg("异常！",{icon:2,time:1200});  
		}  
	});
	
}

function dictclear() {
	var	dicttype = $("#dicttype").val("");
	var	dictname =$("#dictname").val("");
}
function qrydict() {
	var	dicttype = $("#dicttype").val();
	var	dictname =$("#dictname").val();
	$.ajax({
		type:'POST',
		url : "/sys/dict.json?dictname="+dictname+"&dicttype="+dicttype,
		success : function(data) {
		if(data!=null){
			var obj = jQuery.parseJSON(data);
			 $('#dict_tablet').dataTable().fnClearTable();
			 $("#dictGrid").empty();
			 $("#dictGrid").append(obj.table);
			}else{
				layer.msg("异常！返回为空",{icon:2,time:1200});  
			}
		},error : function() {  
			layer.msg("异常！",{icon:2,time:1200});  
		}  
	});
}


function qry(id){
		$("#myModal").modal();
}



</script>

		<title>管理员列表</title>
	</head>
	<body>
		<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span> 系统设置
		<span class="c-gray en">&gt;</span> 业务字典
		<a class="btn btn-success radius r mr-20"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i>
		</a>
		<a class="btn btn-success  radius r mr-20"
			style="line-height: 1.6em; margin-top: 3px;"
			href="javascript:location.replace(location.href);" title="新增"><i
			class="Hui-iconfont">&#xe600;新增业务字典</i>
		</a>
		</nav>
		<div class="pd-20">
			<table class='am-table am-table-centered '
				style='float: left; margin-left: 10px;'>
				<tbody>
					<tr class="am-text-middle ">

						<td colspan="2" width="100%" style="border: 0px">
							<div class="text-c">
								类型名称:

								<input id="dictname" style="width: 80%" type="text"
									class="input-text" placeholder="类型名称" />
							</div>

						</td>
					</tr>
					<tr class="am-text-middle">
						<td colspan="2" width="100%" style="border: 0px">
							<div style="margin-top: 3px" class="text-c">
								类型代码:

								<input id="dicttype" type="text" style="width: 80%"
									class="input-text" placeholder="类型代码" />
							</div>
						</td>
						<td width="90%" style="border: 0px">

						</td>
					</tr>
					<tr class="text-c">
						<td colspan="2" class="am-text-middle " style="border: 0px">
							<button type="submit" class="btn btn-success" onclick="qrydict()"
								style="margin-top: 20px">
								查询
							</button>
							<button type="button" class="btn btn-success"
								onclick="dictclear()" style="margin-top: 20px">
								重置
							</button>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="border: 0px; padding: 0px">

							<table id="dict_table"
								class="table table-border table-bordered table-bg"
								style="margin-top: 20px">
								<thead>
									<tr class="text-c">
										<th style="width: 5%">
											<input type="checkbox" name="" value="">
										</th>
										<th style="width: 35%">
											类型代码
										</th>
										<th style="width: 40%">
											类型名称
										</th>
										<th style="width: 10%">
											字典状态
										</th>
										<th style="width: 10%">
											操作
										</th>
									</tr>
								</thead>
								<tbody id="dictGrid">



								</tbody>
							</table>


				</td>
				</tr>

				<tr>
					<td colspan="3" style="border: 0px; padding: 0px" id="dictBoot">

					</td>
				</tr>
				</tbody>
			</table>

<!-- 弹出窗口 -->

		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<form action="/sys/addDictby.json">
				<div class="modal-header">
					<h3 id="myModalLabel">业务字典信息维护</h3>
					<a class="close" data-dismiss="modal" aria-hidden="true"
						href="javascript:void();">×</a>
				</div>
				<div class="modal-body">
				
				<input type="text" id="a" name="username" value="2222222">
				<input type="text" id="a/c" name="na" value="2222www222">
				
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit">确定</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				</div>
			</form>
		</div></body>
</html>