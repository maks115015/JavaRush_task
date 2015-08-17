<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>User page</title>
</head>
<body>
<h1>User page</h1>
<center>
    <table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
        <thead>
        <tr>
            <th width="25px">id</th><th width="150px">name</th><th width="25px">age</th><th width="50px">admin</th><th width="50px">actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${(users.indexOf(user)+1)}</td>
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

                    <td>
                        <a href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br/>
                        <a href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</center>
<i>${message}</i><br/>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>