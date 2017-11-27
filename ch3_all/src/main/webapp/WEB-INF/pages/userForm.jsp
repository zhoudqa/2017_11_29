<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
	<title>Form Validation</title>
	<!-- 设置CSS由Spring管理 -->
	<link rel="stylesheet" href="<spring:theme code="style"/> " type="text/css">
</head>
<body>
	<h2><spring:message code="welcome"></spring:message> </h2>
	<spring:message code="lang"></spring:message> <a href="?lang=zh_CH">中文</a> - <a href="?lang=en_US">English</a><br>
	<spring:message code="theme"></spring:message>:<a href="?theme=light">Light</a> - <a href="?theme=dark">Dark</a> - <a href="?theme=green">Eye Protection</a>
	<mvc:form modelAttribute="user" action="result.mvc">
		<table>
			<tr>
				<td><spring:message code="name"></spring:message></td>
				<td><mvc:input path="name" cssErrorClass="formFieldError"/></td>
				<td><mvc:errors path="name"></mvc:errors>	
			</tr>
			<tr>
				<td><spring:message code="email"></spring:message></td>
				<td><mvc:input path="email" cssErrorClass="formFieldError"/></td>
				<td><mvc:errors path="email"></mvc:errors>	
			</tr>
			<tr>
				<td><spring:message code="ccNumber"></spring:message></td>
				<td><mvc:input path="ccNumber" cssErrorClass="formFieldError"/></td>
				<td><mvc:errors path="ccNumber"></mvc:errors>
			</tr>
			<tr>
				<td><spring:message code="password"></spring:message></td>
				<td><mvc:password path="password" cssErrorClass="formFieldError"/></td>
				<td><mvc:errors path="password"></mvc:errors>	
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</mvc:form>
</body>
</html>