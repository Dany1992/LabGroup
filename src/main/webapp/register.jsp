<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<s:form action="register">
		<s:textfield name="usr.name" label="Name" />
		<s:textfield name="usr.surname" label="Surname" />
		<s:textfield name="usr.email" label="e-mail" />
		<s:textfield name="usr.password" label="password" />
		<s:submit/>
		</s:form>
</body>
</html>