<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div>
		<table>
			<tr>
				<td>Department Id</td>
				<td>Department Code</td>
				<td>Department Name</td>
			</tr>
			<c:forEach items="departments" var="department">
				<tr>
				<td>${department.empId}</td>
				<td>${department.empName }</td>
				<td>${department.empSalary }</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>