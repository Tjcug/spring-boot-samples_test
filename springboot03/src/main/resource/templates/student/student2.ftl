
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My FTL starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
      <script type="text/javascript">
          $(function(){

          });
      </script>
  </head>
  
  <body>
    ${studentList[0].name}<br/>
    <#list studentList as student>
        name: ${student.name}
        id: ${student.id}
        username:${student.username}<br/>
    </#list>

  </body>
</html>
