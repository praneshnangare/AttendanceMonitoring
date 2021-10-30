<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%!final static String DATE_FORMAT_NOW = "dd-MMM-yyyy";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources1/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources1/js/datetimepicker.js"></script>
<%
SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_NOW);
String date = df.format(new Date());
%>
<script type="text/javascript">
function cll1(){
	console.log("nope this not");
	document.getElementById("toDate").value = document.getElementById("fromDate").value;
}
</script>
<style>
body {
	align-items: flex-start;
}

form .category label {
	display: flex;
	align-items: center;
	cursor: pointer;
	margin: 19px;
}

form .category {
	display: flex;
	width: 80%;
	margin: 0 px 0;
	justify-content: space-between;
}
</style>
</head>
<body>

	<div class="user-details">

		<form:form modelAttribute="dateAndName" method="get"
			action="getAttendanceDetails">
			<div id="emp" style="display: block" class="input-box">

				<form:select path="empId">
					<form:option label="All" value="-1" />
					<form:options items="${empMap }" />
				</form:select>

				<form:input id="fromDate" path="fromDate" type="text"
					value="<%=date%>"
					onclick="javascript:NewCssCal('fromDate' , 'ddMMMyyyy','','','','','past');" onchange ="cll1();"
					style="cursor: pointer" ></form:input>

				<form:input id="toDate" path="toDate" type="text" value="<%=date%>"
					onfocus="javascript:NewCssCal('toDate' , 'ddMMMyyyy','','','','','past')"
					style="cursor: pointer"></form:input>

			</div>
			<input class="button-29" type="submit" value="Submit">
		</form:form>

		<c:if test="${not empty attendanceForm.attendanceList}">
			<form:form modelAttribute="attendanceForm" method="post"
				action="saveAttendanceRecords">
				<div class="in1">
					<table>
						<tr>
							<th><div class="input-box">
									<span class="details">Name</span>
								</div></th>
							<th><div class="input-box">
									<span class="details">Project</span>
								</div></th>
							<th><div class="input-box">
									<span class="details">Status</span>
								</div></th>
							<th><div class="input-box">
									<span class="details">Extra Hrs</span>
								</div></th>
							<th><div class="input-box">
									<span class="details">Remarks</span>
								</div></th>
						</tr>
						<c:forEach items="${attendanceForm.attendanceList}" varStatus="i"
							var="itr">
							<tr>
								<form:input type="hidden"
									path="attendanceList[${i.index}].empId" value="${itr.empId}" />
								<form:hidden class="dateClass"
									path="attendanceList[${i.index}].attendanceDate" />
								<td><div class="input-box">
										<form:input type="text" readonly="true"
											path="attendanceList[${i.index}].name"
											value="${employeeMap[itr.empId].name}" />
									</div></td>
								<td><div class="input-box">
										<input type="text" readonly="true"
											value="${ProjectMap[employeeMap[itr.empId].allocProject]}" />
									</div></td>

								<td><div class="input-box">
										<form:select path="attendanceList[${i.index}].status">
											<form:option value="P" label="Present" />
											<form:option value="A" label="Absent" />
											<form:option value="H" label="Half-Day" />
										</form:select>
									</div></td>
								<td><div class="input-box">
										<form:input path="attendanceList[${i.index}].extraHours" /></td>
								<td><div class="input-box">
										<form:input path="attendanceList[${i.index}].remarks" />
									</div></td>
							</tr>
						</c:forEach>
					</table>
					<div class="button">
						<input type="submit" value="Submit" onclick="setDates();">
					</div>
			</form:form>
		</c:if>
	</div>

</body>
</html>








