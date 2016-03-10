<%@page import="org.apache.struts2.components.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>answerSurvey</title>
</head>
<body>
	<s:iterator value="surveysUser">
		<s:url action="answerSurvey" var="urlTag">
			<s:param name="attribute"><s:property /></s:param>
		</s:url>
		<a href="<s:property value="#urlTag"/>"><s:property /><br></a>
	</s:iterator>
</body>
</html>