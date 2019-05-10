<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@include file="connection.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Integer userId = (Integer)session.getAttribute("userId");
	%>
	<sql:query var="listStud" dataSource="${connectionDS}">
        SELECT * FROM userDetails where userId=<%=userId%>;
    </sql:query>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Student Information</h2>
			</caption>
			<tr>
				<th>StudentID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile NUmber</th>
			</tr>
			<c:forEach var="user" items="${listStud.rows}">
				<tr>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.emailId}" /></td>
					<td><c:out value="${user.mobileNo}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>