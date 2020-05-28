<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h3>Welcome Department Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="saveDepartment" method="POST" modelAttribute="department">
					<div class="row" style="padding: 10px;">
						<div class="col-4">Department Name:</div>
						<div class="col-4">
							<form:input path="deptName" class="form-control" />
						</div>
					</div>
					<div class="row" style="padding: 10px;">
						<div class="col-4">
							<input type="submit" value="Register" class="btn btn-success">
						</div>

					</div>
				</form:form>
			</div>
			<div class="card-footer bg-primary text-white">
			  ${message}
			</div>

		</div>

	</div>


</body>
</html>