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
    
    ----------------root数据显示------------------
    name=<s:property value="some"/><br>
  
  	 ----------------context数据显示------------------
    name=<s:property value="#some"/><br>
   
    ----------------request数据显示------------------
    name=<s:property value="#request.some"/><br>
    <%=request %><br>
    
    <s:set var="userList"  value="{'afas','fdd','ewfw'}"/>
    
    <s:iterator value="#userList">
    	<s:property/>
    </s:iterator><br>
    
    <s:set var="userMap"  value="#{'name':'Kazaf','age':21}"/>
    
    <s:iterator value="#userMap">
    	<s:property/>
    </s:iterator><br>
    
    --------------集合投影---------------<br>
    <s:bean name="com.wjcx.bean.Student" var="student1" >
    	<s:param name="name" value="'Helen'"></s:param>
    	<s:param name="age" value="21"></s:param>
    </s:bean>
    <s:bean name="com.wjcx.bean.Student" var="student2">
    	<s:param name="name" value="'Chard'"></s:param>
    	<s:param name="age" value="21"></s:param>
    </s:bean>
    <s:bean name="com.wjcx.bean.Student" var="student3">
    	<s:param name="name" value="'Ziv'"></s:param>
    	<s:param name="age" value="22"></s:param>
    </s:bean>
    
    -------------使用三个student对象创建List集合------------------<br>
    <s:set var="stus" value="{#student1,#student2,#student3}"/>
    
    -------------使用三个student对象的name属性创建List集合------------------<br>
    <s:set var="stusList" value="#stus.{name}"/>
    <br>
    <s:iterator value="#stusList">
    	<s:property/>
    </s:iterator><br>
    
    <s:debug />
    
   
  </body>
</html>
