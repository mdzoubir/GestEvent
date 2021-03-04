<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/03/2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <c:set var="user" value="${requestScope.users}"/>
    <form method="post" action="UpdateAdmin">
        <input type="hidden" value="${user.id}" name="id">
        <input type="text" value="${user.firstName}" name="fn">
        <input type="text" value="${user.lastName}" name="ln">
        <input type="text" value="${user.email}" name="email">
        <input type="text" value="${user.password}" name="pass">
        <input type="submit" value="Update">
    </form>
</body>
</html>
