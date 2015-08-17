<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit User page</title>
</head>
<body>
<h1>Edit User page</h1>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.id}.html" >
<table>
<tbody>
<tr>
<td>Name:</td>
<td><form:input path="name" /></td>
<td><form:errors path="name" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Age:</td>
<td><form:input path="age"/></td>
<td><form:errors path="age" cssStyle="color: red;"/></td>
</tr>
<tr>
    <td>is admin?:</td>
    <c:if test="${user.isAdmin==1}">
        <td><input type="checkbox" checked="checked" name="isAdmin" path="isAdmin" value="1"/></td>
    </c:if>
    <c:if test="${user.isAdmin<1}">
        <td><input type="checkbox" name="isAdmin" path="isAdmin" value="1"/></td>
    </c:if>
</tr>
<tr>
<td><input type="submit" value="Edit" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>