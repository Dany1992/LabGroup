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
<!-- 	Rispondi al seguente sondaggio <br> -->
<%-- 	<s:iterator value="questionSurvey"> --%>
<%-- 		<s:property value = "question"/><br> --%>
<%-- 		<s:radio name="" list="{rispA,rispB,rispC,rispD}"/><br> --%>
<%-- 	</s:iterator> --%>
	
	<form action="saveAnswer">
	<s:property value = "questionSurvey.get(0).question"/><br>
  	<s:radio name="answer" list="{
  	questionSurvey.get(0).rispA,
  	questionSurvey.get(0).rispB,
  	questionSurvey.get(0).rispC,
  	questionSurvey.get(0).rispD}"/><br>
  	
  	<s:property value = "questionSurvey.get(1).question"/><br>
  	<s:radio name="answer1" list="{
  	questionSurvey.get(1).rispA,
  	questionSurvey.get(1).rispB,
  	questionSurvey.get(1).rispC,
  	questionSurvey.get(1).rispD}"/><br>
  	
  	<s:property value = "questionSurvey.get(2).question"/><br>
  	<s:radio name="answer2" list="{
  	questionSurvey.get(2).rispA,
  	questionSurvey.get(2).rispB,
  	questionSurvey.get(2).rispC,
  	questionSurvey.get(2).rispD}"/><br>
  	
  	<s:property value = "questionSurvey.get(3).question"/><br>
  	<s:radio name="answer3" list="{
  	questionSurvey.get(3).rispA,
  	questionSurvey.get(3).rispB,
  	questionSurvey.get(3).rispC,
  	questionSurvey.get(3).rispD}"/><br>
  	
  	<s:property value = "questionSurvey.get(4).question"/><br>
  	<s:radio name="answer4" list="{
  	questionSurvey.get(4).rispA,
  	questionSurvey.get(4).rispB,
  	questionSurvey.get(4).rispC,
  	questionSurvey.get(4).rispD}"/><br>
  	<br>
  	<s:submit></s:submit>
  	</form>
</body>
</html>