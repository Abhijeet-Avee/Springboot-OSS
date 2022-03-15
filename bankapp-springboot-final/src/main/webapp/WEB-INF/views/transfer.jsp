<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transfer amount</title>
</head>
<body>
<form:form action="transfer" method="post" modelAttribute="transferDto">
	Enter from Account Id:<form:input path="fromAccountNumber"/><br/>
	Enter to Account Id:<form:input path="toAccountNumber"/><br/>
	Enter amount :<form:input path="amount"/><br/>
	<input type ="submit"/>
</form:form>

</body>
</html>