<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crate new account</title>
</head>
<body>
<form:form action="accountops" method="post" modelAttribute="accountDto">
	Enter account number :<form:input path="accNumber"/><br/>
	Enter account type :<form:input path="accType"/><br/>
	Enter interest rate (if applicable):<form:input path="interestRate"/><br/>
	Enter overdraft limit (if applicable):<form:input path="overdraft"/><br/>
	<input type ="submit"/>
</form:form>

</body>
</html>