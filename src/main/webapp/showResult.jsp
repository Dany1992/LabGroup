<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Result</title>
</head>
<body>

<h1>Show Result</h1>

<s:form action="showResult">

<td>Survey : <s:property value="nameSurvey"/> </td>

<br></br>

<s:iterator value="allResult">
        <table>
    <tr>
        <th>Question</th>
        <th>Answer1</th>
        <th>Answer2</th>
        <th>Answer3</th>
        <th>Answer4</th>
    </tr>
    <s:iterator>
        <tr>
            <td><s:property value="getQuestion()"/></td>
            <td><s:property value="getRispA()"/></td>
            <td><s:property value="getRispB()"/></td>
            <td><s:property value="getRispC()"/></td>
            <td><s:property value="getRispD()"/></td>
        </tr>
    </s:iterator> 
</table>
<br></br>
    </s:iterator>

</s:form>



</body>
</html>