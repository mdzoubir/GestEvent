<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 03/03/2021
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="apprenant" value="${requestScope.apprenant}"/>
<c:set var="userId" value="${requestScope.idUser}"/>

    <form method="post" action="UpdateApprenantr">
        <input name="iduser" type="hidden" value="${userId}">
        <input name="id" type="hidden" value="${apprenant.idApprenant}">
        <input name="fn" value="${apprenant.idUsers.firstName}">
        <input name="ln" value="${apprenant.idUsers.lastName}">
        <input name="email" value="${apprenant.idUsers.email}">
        <input name="pass" value="${apprenant.idUsers.password}">
        <select name="specialite">
            <c:forEach var="specialite" items="${requestScope.specialite}">
                <option value="${specialite.nomSpecialite}"><c:out value="${specialite.nomSpecialite}"/></option>
            </c:forEach>
        </select>
        <input value="update" type="submit">
    </form>
</body>
</html>
