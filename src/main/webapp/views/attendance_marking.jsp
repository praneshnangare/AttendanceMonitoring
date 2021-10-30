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
	function setDates() {
		var val = document.getElementById("id1").value;
		console.log("hello");
		console.log(val);
		var list = document.getElementsByClassName("dateClass");
		for (i = 0; i < list.length; i++) {
			list[i].value = val;
		}
	}
</script>

<style>

#attendanceForm tr:hover {
  color: #fff;
  text-align: center;
  -webkit-animation: glow 1s ease-in-out infinite alternate;
  -moz-animation: glow 1s ease-in-out infinite alternate;
  animation: glow 1s ease-in-out infinite alternate;
}

@-webkit-keyframes glow {
  from {
    box-shadow: 0 0 5px #fff, 0 0 7px #fff, 0 0 10px #e60073, 0 0 12px #e60073, 0 0 14px #e60073, 0 0 17px #e60073, 0 0 20px #e60073;
  }
  to {
    box-shadow: 0 0 5px #fff, 0 0 7px #ff4da6, 0 0 10px #ff4da6, 0 0 12px #ff4da6, 0 0 14px #ff4da6, 0 0 17px #ff4da6, 0 0 20px #ff4da6;
  }
}
</style>
</head>
<body>
	<center>
		<c:if test="${not empty attendanceForm.attendanceList}">
			<%
			SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_NOW);
			String date = df.format(new Date());
			System.out.println("date->  " + date);
			%>

			<div class="user-details">
				<table>

					<th><div class="input-box">
							<span class="details">Date</span>
						</div></th>
					<td><div class="input-box">
							<input id="id1" name="one" value="<%=date%>"
								onfocus="javascript:NewCssCal('id1' , 'ddMMMyyyy','','','','','past')"
								style="cursor: pointer" onblur="setDates();" />
						</div></td>
					<div class="button">
						<button onclick="setDates();" value="Submit">
					</div>
					</div>
				</table>
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
			</div>
		</c:if>


	</center>
</body>
</html>








