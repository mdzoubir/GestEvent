<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 03/03/2021
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="formateur" value="${requestScope.formateur}"/>
    <c:set var="userId" value="${requestScope.idUser}"/>

    <form method="post" action="UpdateFormateur">
        <input name="iduser" type="hidden" value="${userId}">
        <input name="id" type="hidden" value="${formateur.idFormatur}">
        <input name="fn" value="${formateur.idusers.firstName}">
        <input name="ln" value="${formateur.idusers.lastName}">
        <input name="email" value="${formateur.idusers.email}">
        <input name="pass" value="${formateur.idusers.password}">
        <select name="specialite">
            <c:forEach var="specialite" items="${requestScope.specialite}">
                <option value="${specialite.nomSpecialite}"><c:out value="${specialite.nomSpecialite}"/></option>
            </c:forEach>
        </select>
        <input value="update" type="submit">
    </form>
</body>
</html>
