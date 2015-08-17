<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User List page</title>
</head>
<body>
<br>
<center>
<h1>User List page</h1>
<a href="${pageContext.request.contextPath}/user/create.html">Create a new user</a><br/>
    <br>

    <form:form method="POST" action="index">
    <table>
        <tbody>
        <tr><td>Find by name</td></tr>
        <tr>
            <td><input name="searchName" type="text"></td>
        <td><input type="submit" value="find" /></td>
    </tr>
        </tbody>
    </table>
    </form:form>
    <i>${message}</i><br/>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="25px">№</th><th width="150px">name</th><th width="25px">age</th><th width="50px">admin</th><th width="70px">timestamp</th><th width="50px">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}">
<tr>
    <td>${(users.indexOf(user)+1)+(page.getNumber()*10)}</td>
    <td>${user.name}</td>
    <td>${user.age}</td>
    <td>
        <c:if test="${user.isAdmin>0}">
            <c:out value="Yes"/>
         </c:if>
        <c:if test="${user.isAdmin<1}">
            <c:out value="No"/>
         </c:if>
    </td>
    <td>${user.date.getDay()}-${user.date.getMonth()}-${user.date.getYear()+1900}<br>${user.date.getHours()}:${user.date.getMinutes()}:${user.date.getSeconds()}</td>

    <td>
        <a href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br/>
        <a href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br/>
    </td>
</tr>
</c:forEach>
</tbody>
</table>
<c:forEach var="li" items="${list}">

    <c:if test="${(page.getNumber()+1)==li}">
        <c:out value="${li}"></c:out>
    </c:if>

    <c:if test="${(page.getNumber()+1)!=li}">
        <a href="index.html?page=${li}"><c:out value="${li}"></c:out></a>
    </c:if>

</c:forEach>

</center>


</body>
</html>