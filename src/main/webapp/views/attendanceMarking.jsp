<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
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
	href="${pageContext.request.contextPath }/resources/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<script type="text/javascript">
	function setDates(){
		var val = document.getElementById("id1").value;
		console.log("hello");
		console.log(val);
		var list = document.getElementsByClassName("dateClass");
		for(i =0;i<list.length;i++){
			list[i].value = val;
		}
	}
	
	</script>
</head>
<body>
<center>
	<c:if test="${not empty attendanceForm.attendanceList}">
		<%
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_NOW);
		String date = df.format(new Date());
		%>
		<table>
			<tr>
				<th>Date</th>
				<td><input id="id1" name="one"
					onfocus="javascript:NewCssCal('id1' , 'ddMMMyyyy','','','','','past')"
					style="cursor: pointer" onblur = "setDates();"/></td>
				<td><img
					src="${pageContext.request.contextPath}/resources/images2/cal.gif"
					onclick="javascript:NewCssCal('id1' , 'ddMMMyyyy','','','','','past')"
					style="cursor: pointer" /></td>
				<td><button
						onclick="setDates();" value = "Submit">Submit</button></td>
			</tr>
		</table>
		<form:form modelAttribute="attendanceForm" method="post"
			action="saveAttendanceRecords">
			<table>
				<tr>
					<th>Name</th>
					<th>Project</th>
					<th>Status</th>
					<th>Extra Hrs</th>
					<th>Remarks</th>
				</tr>
				<c:forEach items="${attendanceForm.attendanceList}" varStatus="i"
					var="itr">
					<tr>
						<form:input type="hidden" path="attendanceList[${i.index}].empId"
							value="${itr.empId}" />
						<td><form:input type="text" readonly="true"
								path="attendanceList[${i.index}].name"
								value="${employeeMap[itr.empId].name}" /></td>
						<td><c:out
								value="${ProjectMap[employeeMap[itr.empId].allocProject]}" /></td>
						<td><form:hidden class="dateClass"
								path="attendanceList[${i.index}].attendanceDate" /></td>
						<td><form:select path="attendanceList[${i.index}].status">
								<form:option value="P" label="Present" />
								<form:option value="A" label="Absent" />
								<form:option value="H" label="Half-Day" />
							</form:select></td>
						<td><form:input path="attendanceList[${i.index}].extraHours" /></td>
						<td><form:input path="attendanceList[${i.index}].remarks" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="submit">
		</form:form>
	</c:if>
</center>
</body>
</html>








