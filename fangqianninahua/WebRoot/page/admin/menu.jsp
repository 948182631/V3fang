<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>

	<script>
		 $(function() {
				$.ajax({
					type:'POST',
					url : "menu/menulist.json",
					async: false,
					success : function(data) {
					if(data!=null){
						 $("#SCMENU").html(data);
						}else{
							alert("异常！返回为空");  
						}
					
					},error : function() {  
						alert("异常！");  
					}  
				});
			    var tabCounter = 0;
			    var $tab = $('#doc-tab-demo-1');
			    var $nav = $tab.find('.am-tabs-nav');
			    var $bd = $tab.find('.am-tabs-bd');
			  
			    function addTab(aherf,url,texts) {
			      var listJspUrl =url;
			      var nav = '<li  ><span class="am-icon-close"></span>' +
			        '<a  id="'+aherf+'"href="javascript: void(0)">'+texts+'</a></li>';
			      var content = '<div class="am-tab-panel " id="t'+aherf+'" >';
			  	  var contents =' </div>';
			      $nav.append(nav);
			      $bd.append(content);
			      $($("#t" +aherf)).load(listJspUrl);
			      $bd.append(contents);
			      $tab.tabs('refresh');
			      $tab.tabs('open', $nav.find('li').length-1);
			    }

			    // 动态添加标签页
			    $('.menuss').on('click', function() {
			    	var id = $(this).attr("id")+"tab";
			    	var url= $(this).attr("name");
			    	var texts= $(this).text();
			   		if($($("#" +id)).length==0){
			   		 addTab(id,url,texts);
				   }else{
			    	  $tab.tabs('open', $($("#" +id))); 
				   }
			     
			    });
			    $('.js-append-tab').on('click', function() {
			        addTab();
			      });

			    // 移除标签页
			    $nav.on('click', '.am-icon-close', function() {
			      var $item = $(this).closest('li');
			      var index = $nav.children('li').index($item);
			      $item.remove();
			      $bd.find('.am-tab-panel').eq(index).remove();
			      $tab.tabs('open', index > 0 ? index - 1 : index + 1);
			      $tab.tabs('refresh');
			    });
			  });

		    
	</script>
	<body >
	
	
	
	
	<!-- 按钮触发器， 需要指定 target -->


        <div id="SCMENU">


		</div>

	
	


	</body>
</html>
