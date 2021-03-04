<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 01/03/2021
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="AddFormateur">
        <input type="text" placeholder="First name" name="fn">
        <input type="text" placeholder="Last name" name="ln">
        <input type="email" placeholder="email@example.com" name="email">
        <input type="password" placeholder="*******" name="pass">
        <select name="specialite">
            <c:forEach var="specialite" items="${requestScope.specialite}">
                <option value="${specialite.nomSpecialite}"><c:out value="${specialite.nomSpecialite}"/></option>
            </c:forEach>
        </select>
        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
