<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<!---<title> Responsive Registration Form | CodingLab </title> --->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/NewFile.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<script type="text/javascript">
	function getDepartmentList() {
		document.forms["form1"].action = "${page}/getDepartmentList.html";
		document.forms["form1"].method = "post";
		document.forms["form1"].submit();
	}
</script>
</head>
<body>
	<div class="container">
		<div class="title">Registration</div>
		<div class="content">
			<form:form name="form1" modelAttribute="empBean"
				action="registerEmployee">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Full Name</span>
						<form:input path="Name" type="text" placeholder="Enter your name"
							required="true" />
						<form:errors class="errors" path="Name" />
					</div>
					<!--           <div class="input-box"> -->
					<!--             <span class="details">Username</span> -->
					<%--             <form:input  type="text" placeholder="Enter your username" required/> --%>
					<!--           </div> -->
					<div class="input-box">
						<span class="details">Email</span>
						<form:input path="Email" type="text"
							placeholder="Enter your email" required="true" />
						<form:errors class="errors" path="Email" />
					</div>
					<div class="input-box">
						<span class="details">Phone Number</span>
						<form:input path="PhoneNo" type="text"
							placeholder="Enter your number" required="true" />
						<form:errors class="errors" path="PhoneNo" />
					</div>
					<div class="input-box">
						<span class="details">Adhar Card No :</span>
						<form:input path="AdharCardNo" type="text"
							placeholder="Enter your Adhar No" required="true" />
						<form:errors class="errors" path="AdharCardNo" />
					</div>
					
<!-- 					<div class="input-box"> -->
<!-- 						<span class="details">Password</span> <input type="password" -->
<!-- 							placeholder="Enter your password" required="true"> -->
<!-- 					</div> -->
<!-- 					<div class="input-box"> -->
<!-- 						<span class="details">Confirm Password</span> <input -->
<!-- 							type="password" placeholder="Confirm your password" -->
<!-- 							required="true"> -->
<!-- 					</div> -->



					<div class="input-box">
						<span class="details">Allocated Project</span>
						<form:select path="AllocProject" onchange="getDepartmentList();">
							<form:option label="--Select--" value="" />
							<form:options items="${ProjectMap }" />
						</form:select>
						<form:errors class="errors" path="AllocProject" />
					</div>

<!-- 					<div class="input-box"> -->
<!-- 						<span class="details">Department</span> -->
<%-- 						<form:select path="Department"> --%>
<%-- 							<form:option label="--Select--" value="" /> --%>
<%-- 							<form:options items="${departmentList }" itemValue="deptId" --%>
<%-- 								itemLabel="deptName" /> --%>
<%-- 						</form:select> --%>
<%-- 						<form:errors class="errors" path="Department" /> --%>
<!-- 					</div> -->
					
					<div class="input-box">
						<span class="details">Date Of Joining</span>
						<form:input readonly = "true" id="dateTimePicker1" path="DOJ" required="true"
							placeholder="Enter your Date of Joining" onclick="javascript:NewCssCal('dateTimePicker1' , 'ddMMMyyyy','','','','','past')" />
						
						<form:errors class="errors" path="DOJ" />
					</div>
					<div class="input-box">
						<span class="details">Per Day</span>
						<form:input path="PerDay" type="text"
							placeholder="Enter your Per Day Pay" required="true" />
						<form:errors class="errors" path="PerDay" />
					</div>
				
				<div class="gender-details">
					<input type="radio" value = "male" name="gender" id="dot-1"> <input
						type="radio" value ="female" name="gender" id="dot-2"> <span
						class="gender-title">Gender</span>
					<div class="category">
						<label for="dot-1"> <span class="dot one"></span> <span
							class="gender">Male</span>
						</label> <label for="dot-2"> <span class="dot two"></span> <span
							class="gender">Female</span>
						</label>
					</div>
				</div>
				</div>
				<div class="button">
					<input type="submit" value="Register">
				</div>
			</form:form>
			<h3>${msg}</h3>
		</div>
	</div>

</body>
</html>









