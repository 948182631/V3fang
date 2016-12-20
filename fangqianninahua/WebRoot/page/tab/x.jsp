<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script src="<%=basePath%>js/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
$(function() {

	$.ajax({
		type:'POST',
		url : "create/create.json",
		success : function(data) {
		if(data!=null){
			 var dataObj=eval(data);
			 var html="";
			 $.each(dataObj, function(i, item) {
				 var obj = jQuery.parseJSON(item);

				 var img ="	<table class='am-table-centered' style='float: left;margin-left: 10px;' >    <tbody> <tr><td>";
				 img =img+"	<img alt='' src='<%=request.getContextPath()%>/page/tab/picCreate.jsp?ppath="+obj.one+"'>";
				 img= img+"</td> </tr>  <tr  >  <td >";
				 img=img+"	<img alt='' src='<%=request.getContextPath()%>/page/tab/picCreate.jsp?ppath="+obj.two+"'>";
				 img =img+" </td>    </tr>   <tr  >  <td > " ;
				 img=img+obj.text;
				 img =img+" </td>    </tr> </tbody>	</table>";
				 html =html+img;
		        });
			 $("#xhtml").html(html);
			}else{
				alert("异常！返回为空");  
			}
		
		},error : function() {  
			alert("异常！");  
		}  
	});
});

function  print(){
    $("#xhtml").jqprint();
}
</script>

<div class="am-tab-panel am-active">
	<table class='am-table-centered'
		style='float: left; margin-left: 10px;'>
		<tbody>
			<tr>
				<td>
					<dir id="xhtml"></dir>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
		
					<button type="button" class="am-btn am-btn-secondary"
						onclick="print()">
						打印二凭证
					</button>
				
				</td>
			</tr>
		</tbody>
	</table>
</div>