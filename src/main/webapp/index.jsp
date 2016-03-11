<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Home</title>
</head>
<body>
	<h1>Benvenuti al sito per sondaggi</h1>
	
	<a href="login.jsp">Login</a>
	<a href="<s:url action='register'/>">Register</a>
	<a href="<s:url action='newSurvey2'/>">Create Survey</a>
	<a href="<s:url action='showResult'/>">Show Result"sorcio"</a>
	<a href="<s:url action='selectUser'/>">CreateAdmin</a>
</body>
</html>