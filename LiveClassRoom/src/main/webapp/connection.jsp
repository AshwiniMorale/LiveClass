<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
	<sql:setDataSource var="connectionDS"
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/liveclassroom" 
		user="root"
		password="root" />
	<c:set var="connectionDS" scope="request" />
</body>
</html>

