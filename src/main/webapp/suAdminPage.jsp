<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Super Admin Panel</title>
</head>
<body>
<%
session=request.getSession(false);
%>
Hello <s:property value="#session['name']" />
<s:property value="#session['surname']" />
<s:url action="logout.action" var="urlTag" ></s:url>
<a href="<s:property value="#urlTag" />" >Logout.</a>
<a href="<s:url action='newSurvey2'/>">Create Survey</a>
</body>
</html>