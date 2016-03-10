<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Super Admin Panel</title>
</head>
<body>
<h1>Super Admin Panel</h1>
<%
session=request.getSession(false);
%>

Hello <s:property value="#session['name']" /> 
<s:property value="#session['surname']" />
<br>
<s:url action="logout.action" var="urlTag" ></s:url>
<br>
<a href="<s:url action='newSurvey2'/>">Create Survey</a>
<br>
<a href="<s:property value="#urlTag" />" >Logout.</a>
<br></br>

<s:form action="showResult">
<table>
<s:combobox label="Show Result" list="allSurvey" name="nameSurvey" value="Select Survey" headerKey="-1" headerValue="--- Select Survey ---"/>
<s:submit/>
</table>
</s:form>


</body>
</html>

