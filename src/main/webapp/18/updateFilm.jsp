<%@page import="com.hand.entity.Language"%>
<%@page import="com.hand.entity.Film"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  <form action="filmAction?command=update">
    <div>
		<table width="" class="film_table" id="filmTable" border="0" style="text-align: center;">
			<tr class="film_title">
				<td width="80">题目</td>
				<td width="80">简介</td>
				<td width="80">语言</td>
				<td width="80"></td>
				
			</tr>
<%Film film=request.getAttribute("film")!=null?(Film)request.getAttribute("film"):null;
					%>
			<tr >
			
				<td width="300"><input type="text" value="<%=film.getTitle()%>" style="width: 400px ;height: 50px;" name="title" ></td>
				<td width="300"><input type="text" value="<%=film.getDescription() %>" style="width: 400px;height: 50px;" name="description" ></td>
				<td width="300"><input type="text" value="<%=film.getName() %>"style="width: 400px;height: 50px;"></td>
				<td width="300"><select name="" id="selectAdd">
												<%
													Collection<Language> languages=request.getAttribute("languages")!=null?(Collection)request.getAttribute("languages"):null;
																	for(Language language : languages ){
												%>
												<option value=""><%=language.getName()%></option>
												<%
													}
												%>
										</select></td>
				<td><input type="submit" value="确认添加"></td>
				<td><input type="submit" value="确认修改"></td>
			</tr>
			</table>
			</div></form>
  </body>
</html>
