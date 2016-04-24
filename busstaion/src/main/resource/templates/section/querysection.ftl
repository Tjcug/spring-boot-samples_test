
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<#include "../public/head.ftl">
<html>
  <head>
    <title>公交车管理系统</title>
    <script type="text/javascript">
    	$(function(){
		$('#dg').datagrid({
				url : 'roadsection_queryRoadSection.action',
				striped:true,
				nowrap:true,
				fitColumns:true,
		/*rowStyler : function(index, row) {
					if (index%2==0) {
						 return 'background-color:#6293BB;color:#ff0000;';
					}else{
						 return 'background-color:#6293BB;color:#00ff00;';
					}
				},*/
				idField:"id",
				toolbar: [{
					iconCls: 'icon-edit',
					text:"编辑公交线路端信息",
					handler: function()
					{
						var rows=$("#dg").datagrid("getSelections");
						if(rows.length!=1){
							$.messager.show({
								title : '消息提示',
								msg : '只能编辑一个公交线路',
								timeout : 2000,
								showType : 'slide'
							});

						} else {W
							window.open("send_road_updateroad.action?id="+rows[0].id);
						}
					}
				},'-', {
					text : "<input id='search' />"
				} ],

				queryParams : {
					name : ''
				},
				pagination : true,
				frozenColumns : [ [ {
					field : 'fdsf',
					checkbox : true
				}, {
					field : 'id',
					title : '编号',
					width : 100
				} ] ],
				columns : [ [ {
					field : 'name',
					title : '公交线路段名称',
					width : 100
				}, 
				{
					field : 'statrtstation',
					title : '线路端起点名称',
					width : 100
				},{
					field : 'endstation',
					title : '线路端终点名称',
					width : 150,
					formatter : function(value, row, index) {
						return "<span>"+value+"</span>";
					}
				},{
					field : 'elapsedtime',
					title : '线路端经过时间',
					width : 150,
					formatter : function(value, row, index) {
						return "<span>"+value+"</span>";
					}
				}] ]
			});

			$('#search').searchbox({
				searcher : function(value, name) {
					$('#dg').datagrid('load', {
						name : value
					});
				},
				prompt : 'Please Input Value'
			});

		});
    </script>
  </head>

  <body>
 	<table id="dg" ></table>  
 	<div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
</body>
</html>
