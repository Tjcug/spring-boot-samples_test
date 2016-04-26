
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<#include "../public/head.ftl">
<html>
  <head>
    <title>公交车管理系统</title>
    <script type="text/javascript">
    $(function(){
		var map = new BMap.Map("container");
		addControlMap(map,"武汉",12);

			$("input[id=startaddress]").validatebox({
				required : true,
				missingMessage:"请输入一个起始地址"
			});  
			
			$("input[id=endaddress]").validatebox({
				required : true,
				missingMessage:"请输入一个结束地址"
			});  
			
			$("#search").click(function(){
				remove_overlay(map);
				deletePoint(map);
				var startaddress=$("#startaddress").val();
				var endaddress=$("#endaddress").val();
				ajax("roadsearch.action",{startstation:startaddress,endstation:endaddress,type:1},"post",onsuccess);
			});

			function onsuccess(data){
				if(data.status=="success"){
					var str="";
					for(var a=0;a<data.roadstations.length;a++){
                        str+=data.roadstations[a].name+",";
					}
                    str+="weight"+data.weight;
					alert(str);
				}else{
					alert(data.status);
				}
			}
		});
    </script>
  </head>
<body>
	输入起始地址: <input type="text" id="startaddress">
	输入结束地址: <input type="text" id="endaddress">    
	 <a id="search"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">搜索</a>  
 	<div id="container"
			style="position: absolute;  width: 100%; height: 90%; overflow:hidden;">
	</div>
</body>
</html>
