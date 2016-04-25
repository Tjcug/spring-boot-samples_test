
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My FTL starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>

    <#include "header.ftl" parse=true encoding="utf-8"/>
    <table border="1">
        <tr>
            <td>用户ID</td>
            <td>用户名</td>
            <td>用户年龄</td>
            <td>用户年级</td>
            <td>操作</td>
        </tr>
        <#list students as student>
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.grade.classname}</td>
                <td><a href="/student/findALL">删除</a></td>
            </tr>
        </#list>
    </table>
  </body>
</html>
