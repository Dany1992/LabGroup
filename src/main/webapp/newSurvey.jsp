<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Survey</title>
</head>
<body>
<h1>New Survey</h1>
 
 
<s:form action="newSurvey">

<%
session=request.getSession(false);
%>
   <td>Name_User : <s:property value="#session['name']" />  </td>
   <table>
   <s:textfield name="s.name" label="Survay"/>
   <s:combobox label="Categorie" list="allCategory" name="s.category" value="Select Category" headerKey="-1" headerValue="--- Select Category ---"/>
   </table>
   <br>
   <table>
   <s:textfield name="q0.question" label="Question 1"/>
   <s:textfield name="q0.rispA" label="Answer A"/>
   <s:textfield name="q0.rispB" label="Answer B"/>
   <s:textfield name="q0.rispC" label="Answer C"/>
   <s:textfield name="q0.rispD" label="Answer D"/>
   </table>
   <br>
   <table>
   <s:textfield name="q1.question" label="Question 2"/>
   <s:textfield name="q1.rispA" label="Answer A"/>
   <s:textfield name="q1.rispB" label="Answer B"/>
   <s:textfield name="q1.rispC" label="Answer C"/>
   <s:textfield name="q1.rispD" label="Answer D"/>
   </table>
   <br>
   <table>
   <s:textfield name="q2.question" label="Question 3"/>
   <s:textfield name="q2.rispA" label="Answer A"/>
   <s:textfield name="q2.rispB" label="Answer B"/>
   <s:textfield name="q2.rispC" label="Answer C"/>
   <s:textfield name="q2.rispD" label="Answer D"/>
   </table>
    <br>
   <table>
   <s:textfield name="q3.question" label="Question 4"/>
   <s:textfield name="q3.rispA" label="Answer A"/>
   <s:textfield name="q3.rispB" label="Answer B"/>
   <s:textfield name="q3.rispC" label="Answer C"/>
   <s:textfield name="q3.rispD" label="Answer D"/>
   </table>
   <br>
   <table>
   <s:textfield name="q4.question" label="Question 5"/>
   <s:textfield name="q4.rispA" label="Answer A"/>
   <s:textfield name="q4.rispB" label="Answer B"/>
   <s:textfield name="q4.rispC" label="Answer C"/>
   <s:textfield name="q4.rispD" label="Answer D"/>
   <s:submit/>
   </table>
</s:form>

	



</body>
</html>

