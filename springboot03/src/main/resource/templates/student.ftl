
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My FTL starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
      <script type="text/javascript">
          $(function(){
              $("#btn").click(function(){

                  $.ajax({
                      url: "http://localhost:8080/test5",
                      type: "post",
                      dataType: "json",
                      success: function (data) {
                          for (var i = 0; i < data.length; i++) {
                              var student = data[i];
                             var str= student.name + "," + student.id ;
                              $("#data").append("<p>"+str+"</p>")
                          }
                      }
                  });
              });

          });
      </script>
  </head>
  
  <body>
    <input type="button" id="btn" value="查询所有">
    <p id="data"></p>
  </body>

</html>
