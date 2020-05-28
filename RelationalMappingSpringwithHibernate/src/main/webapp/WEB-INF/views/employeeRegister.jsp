<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Register Page</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h3>Welcome to Employee Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="saveEmp" method="POST" modelAttribute="employee">
					<div class="row" style="padding: 10px;">
						<label>Employee Name:</label>
						<div class="col-4">
							<form:input path="empName" class="form-control" />
						</div>
						<label>Employee Salary:</label>
						<div class="col-4">
							<form:input path="empSalary" class="form-control" />
						</div>
					</div>
					<div class="row" style="padding: 10px;">
						<label>Employee Department:</label>
						<div class="col-4">
							<form:select path="dept" class="form-control">
								<c:forEach items="${departments}" var="department">
									<form:option value="${department.deptId }">${department.deptName}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row" style="padding: 10px;">
						<div class="col-4">
							<input type="submit" value="Register" class="btn btn-success">
						</div>

					</div>
				</form:form>
			</div>
			<div class="card-footer bg-primary text-white">${message}</div>
		</div>

	</div>

</body>
</html>