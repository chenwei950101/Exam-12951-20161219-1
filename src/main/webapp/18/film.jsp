<%@page import="com.hand.entity.Film"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
</head>

<body>
	<div>

		<table width="" class="film_table" id="filmTable" border="0" style="text-align: center;">
			<tr class="film_title">
				<td width="80">ID</td>
				<td width="80">题目</td>
				<td width="80">简介</td>
				<td width="80">语言</td>
				<td width="80">修改</td>
				<td width="80"><a href="addFilm.jsp">添加新电影</a></td>
			</tr>
<% Collection<Film> films=session.getAttribute("films")!=null?(Collection)session.getAttribute("films"):null;
					for(Film film:films){
			%>
			<tr >
				<td width="100"><%=film.getFilm_id() %></td>
				<td width="200"><%=film.getTitle()%></td>
				<td width="400"><%=film.getDescription() %></td>
				<td width="200"><%=film.getName() %></td>
				<td width="200"><a href="filmAction?command=toUpdate&film_id=<%=film.getFilm_id() %>">修改</a>/<a href="filmAction?command=delete&film_id=<%=film.getFilm_id() %>">删除</a></td>
			</tr>
<%} %>
		</table>
	</div>
</body>
</html>
