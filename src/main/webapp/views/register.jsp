
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<script type="text/javascript">
function getDepartmentList(){
	document.forms["form1"].action = "${page}/getDepartmentList.html";
	document.forms["form1"].method = "post";
	document.forms["form1"].submit();
}
</script>
</head>
<body>
	<center>
		<h1>Register Employee</h1>
		<form:form name = "form1" modelAttribute="empBean" action="registerEmployee">
			<table>
				<tr>
					<th>Employee Name :</th>
					<td><form:input path="Name" /></td>
					<td><form:errors class = "errors" path = "Name"/></td>
				</tr>

				<tr>
					<th>Per Day</th>
					<td><form:input path="PerDay" /></td>
					<td><form:errors class = "errors" path = "PerDay"/></td>
				</tr>

				<tr>
					<th>Phone No :</th>
					<td><form:input path="PhoneNo" /></td>
					<td><form:errors class = "errors" path = "PhoneNo"/></td>
				</tr>

				<tr>
					<th>Adhar Card No :</th>
					<td><form:input path="AdharCardNo" /></td>
					<td><form:errors class = "errors" path = "AdharCardNo"/></td>
				</tr>
				<tr>
					<th>Gender</th>
					<td><form:select path="Gender">
							<form:option label="--Select--" value="" />
							<form:options items="${GenderMap }" />
						</form:select></td>
						<td><form:errors class = "errors" path = "Gender"/></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><form:input path="Email" /></td>
					<td><form:errors class = "errors" path = "Email"/></td>
				</tr>
				<tr>
					<th>Allocated Project</th>
					<td><form:select path="AllocProject" onchange = "getDepartmentList();">
							<form:option label="--Select--" value="" />
							<form:options items="${ProjectMap }" />
						</form:select></td>
						<td><form:errors class = "errors" path = "AllocProject"/></td>
				</tr>
				<tr>
					<th>Department</th>
					<td><form:select path="Department">
							<form:option label="--Select--" value="" />
							<form:options items="${departmentList }" itemValue = "deptId" itemLabel = "deptName"/>
						</form:select></td>
						<td><form:errors class = "errors" path = "Department"/></td>
				</tr>

				<tr>
					<th>Date Of Joining</th>
					<td><form:input id="dateTimePicker1" path="DOJ" /></td>
					<td><img src="${pageContext.request.contextPath}/resources/images2/cal.gif"
						onclick="javascript:NewCssCal('dateTimePicker1' , 'ddMMMyyyy','','','','','past')"
						style="cursor: pointer" /></td>
					<td><form:errors class = "errors" path = "DOJ"/></td>
				</tr>
			</table>
			<input type="submit" value="Register">
		</form:form>
		<h2>${msg}</h2>
	</center>
</body>
</html>