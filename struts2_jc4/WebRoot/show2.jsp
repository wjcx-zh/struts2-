<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 读取非根数据 -->
 	<%--  some=<s:property value="#some"/> --%>
    
   --------------context数据显示 -----------------
    name=<s:property value="#stu.name"/><br>
    age=<s:property value="#stu.age"/><br>
    
    ---------------- el数据显示 ----------------
    ename=${requestScope.stu.name }<br>
    eage=${requestScope.stu.age }<br>
    
    ---------------- el数据显示 ----------------
    ename=${stu.name }<br>
    eage=${stu.age }<br>
    
    --------------context数据显示 -----------------
    name=<s:property value="#stu1.name"/><br>
    age=<s:property value="#session.stu1.age"/><br>
    
    ----------------session el数据显示 ----------------
    ename=${stu1.name }<br>
    eage=${sessionScope.stu1.age }<br>
    
    ---------------- el数据显示 ----------------
    ename=${stu1.name }<br>
    eage=${stu1.age }<br>
    
     --------------context数据显示 -----------------
    name=<s:property value="#application.stu2.name"/><br>
    age=<s:property value="#application.stu2.age"/><br>
    
    ---------------- el数据显示 ----------------
    ename=${applicationScope.stu2.name }<br>
    eage=${applicationScope.stu2.age }<br>
    
    ---------------- el数据显示 ----------------
    ename=${stu2.name }<br>
    eage=${stu2.age }<br>
    
    ----------------jsp通过attr的key读取数据------------------
    --------------context数据显示 -----------------
    name=<s:property value="#attr.stu2.name"/><br>
    age=<s:property value="#attr.stu2.age"/><br>
    
    --------------root数据显示 【不存在的shuju】-----------------
    name=<s:property value="#attr.stu3.name"/><br>
    age=<s:property value="#attr.stu3.age"/><br>
   
    <s:debug />
    
    
  </body>
</html>
