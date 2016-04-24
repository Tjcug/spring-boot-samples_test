
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <#include "../public/head.ftl">

        <style type="text/css">
            #search {
                margin-top: 6;
            }
            #fm{
                margin:0;
                padding:10px 30px;
            }
            .ftitle{
                font-size:14px;
                font-weight:bold;
                color:#666;
                padding:5px 0;
                margin-bottom:10px;
                border-bottom:1px solid #ccc;
            }
            .fitem{
                margin-bottom:5px;
            }
            .fitem label{
                display:inline-block;
                width:80px;
            }
        </style>

      <script type="text/javascript">
          $(function(){
              $('#dg').datagrid('load', {
                  userName : ''
              });

              $('#search').searchbox({
                  searcher : function(value, name) {
                      $('#dg').datagrid('load', {
                          userName : value
                      });
                  },
                  prompt : 'Please Input Value'
              });
          });


          var url;
          function newUser(){
              $('#dlg').dialog('open').dialog('setTitle','新建用户');
              $('#fm').form('clear');
              url = "${tour}/tuser/save";
          }

          function editUser(){
              var rows = $('#dg').datagrid('getSelections');
              if(rows.length!=1) {
                  showInfoMessage("只能编辑一个用户");
              }else{
                  var row=rows[0];
                  $('#dlg').dialog('open').dialog('setTitle','编辑用户');
                  $('#fm').form('load',row);
                  url = '${tour}/tuser/update?id='+row.id;
              }
          }

          function saveUser() {
              $('#fm').form('submit', {
                  url: url,
                  onSubmit: function () {
                      return $(this).form('validate');
                  },
                  success: function (result) {
                      var result = eval('(' + result + ')');
                      if (result.errorMsg) {
                          $.messager.show({
                              title: 'Error',
                              msg: result.errorMsg
                          });
                      } else {
                          $('#dlg').dialog('close');		// close the dialog
                          $('#dg').datagrid('reload');	// reload the user data
                      }
                  }
              });
          }
              /**
               * 性别修改器
               * @param val 值
               * @param row 行
               */
              function sexformatter(val,row){
                  if(val==0){
                      return '<span style="color:red;">男生</span>';
                  }else if(val==1){
                      return '<span style="color:green;">女生</span>';
                  }
              }

          /**
           * 删除用户
           */
          function destroyUser() {
              var rows = $('#dg').datagrid('getSelections');
              if (rows.length != 1) {
                  showInfoMessage("只能删除一个用户");
              } else {
                  var row = rows[0];
                  $.messager.confirm('提示信息', '你确定删除该用户吗？', function (r) {
                      if (r) {
                          $.post('${tour}/tuser/delete', {id: row.id}, function (result) {
                              if (result.success) {
                                  $('#dg').datagrid('load', {
                                      userName: ''
                                  });
                              } else {
                                  $.messager.show({	// show error message
                                      title: 'Error',
                                      msg: result.errorMsg
                                  });
                              }
                          }, 'json');
                      }
                  });
              }
          }

      </script>

  </head>
  
  <body>
      <table id="dg" title="我的用户" class="easyui-datagrid"
             url="${tour}/tuser/queryUserByPage"
             toolbar="#toolbar"
             pagination= true
             striped=true
             nowrap=true
             idField="id"
             rownumbers="true" fitColumns="true">

          <thead frozen="true">
              <tr>
                  <th field="ck" checkbox="true"></th>
                  <th field="id" width="30">id</th>
              </tr>
          </thead>

          <thead>
          <tr>
              <th field="userName" width="50">用户名</th>
              <th field="email" width="50">邮箱</th>
              <th field="password" width="50">密码</th>
              <th field="sex" formatter="sexformatter" width="50">性别</th>
              <th field="birthday" width="50">生日</th>
              <th field="picture" width="50">图片</th>
              <th field="country" width="50">国家</th>
              <th field="city" width="50">城市</th>
              <th field="creditcard" width="50">银行卡</th>
              <th field="telephone" width="50">电话号码</th>
              <th field="score" width="50">评分等级</th>
              <th field="longitude" width="50">纬度</th>
              <th field="latitude" width="50">经度</th>
              <th field="time" width="50">新建用户时间</th>
          </tr>
          </thead>
      </table>

      <div id="toolbar">
          <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建用户</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
          <input id="search">
      </div>

      <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
           closed="true" buttons="#dlg-buttons">
          <div class="ftitle">用户信息</div>
          <form id="fm" method="post">
              <div class="fitem">
                  <label>用户名</label>
                  <input name="userName" class="easyui-validatebox" required="true">
              </div>
              <div class="fitem">
                  <label>邮箱</label>
                  <input name="email" class="easyui-validatebox" validType="email" required="true">
              </div>
              <div class="fitem">
                  <label>密码</label>
                  <input name="password" class="easyui-validatebox" required="true" >
              </div>
          </form>
      </div>
      <div id="dlg-buttons">
          <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
      </div>

  </body>
</html>
