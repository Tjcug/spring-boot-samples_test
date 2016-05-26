
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
  </head>
  
  <body>
    ----------------------------------<br/>
    <#if random gte 90>
        优秀
        <#elseif random gte 60>
        良好
        <#else >
        不及格
    </#if>

    <#--定义带有宏的指令-->
  <#macro m1>
      aaaa
      bbbb
      cccc
  </#macro>
  <@m1 />

    <#--定义带有参数的宏的指令-->
  <#macro m2 a b c>
    ${a}-----  ${b}-----  ${c}-----
  </#macro>
  <@m2 "张三" "李四" "王五"/>


    <#--nested嵌入内容的宏指令-->
  <#macro m3>
      <#nested >
  </#macro>
  <@m3 >fdsfsdfsdfsafdsaf</@m3>

    <#--定义变量-->
  <#assign mail="798750509@qq.com">
  ${mail}

  ----------------------------FreeMarker基本数据类型-----------------
  <#assign map={"name":"tanjie","age":16}>
  <#assign list=[1,2,3,5,6,7,8]>
  ${map.name}

  ${list[0]}

  <#list list as num>
      ${num}
  </#list>

  ${date?string("yyyy-MM-dd hh:mm:ss")}

  ${list?size}<br/>

  -----------------------------FreeMarker空值字符串处理----------------
  sss 没有这个变量会报错<br/>
  ${sss!}没有这个变量默认值是空字符串<br/>
  ${sss!"abc"}没有这个变量默认值是'abc"<br/>

  <#if sss??>
    <h1>${sss}</h1>     如果这变量存在返回true不存在返回false
  </#if>

  ------------------------------FreeeMarker内置对象-------------------
  ${Request.random}
  ${Request.method!}fasf
  </body>
</html>
