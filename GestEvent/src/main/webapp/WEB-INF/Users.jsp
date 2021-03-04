
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="./css/admin.css">
    <link rel="stylesheet" href="./css/style.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <section>
        <div class="container">
            <table id="table" border="1"  class="table table-bordered " style="margin-top: 20px">
                <tr>
                    <th>first name</th>
                    <th>last name</th>
                    <th>email</th>
                    <th>role</th>
                    <th>Speciliate</th>
                </tr>

                <c:forEach var="user" items="${requestScope.user}" >
                    <c:if test="${user.role.equals(requestScope.admin)}" >
                        <tr>
                            <td><c:out value="${user.firstName}"/></td>
                            <td><c:out value="${user.lastName}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.role}"/></td>
                            <td></td>
                        </tr>
                    </c:if>
                </c:forEach>
                <c:forEach var="appr" items="${requestScope.apprenant}" >
                    <tr>
                        <td><c:out value="${appr.idUsers.firstName}"/></td>
                        <td><c:out value="${appr.idUsers.lastName}"/></td>
                        <td><c:out value="${appr.idUsers.email}"/></td>
                        <td><c:out value="${appr.idUsers.role}"/></td>
                        <td><c:out value="${appr.idSpecialite.nomSpecialite}"/></td>
                    </tr>
                </c:forEach>
                <c:forEach var="formateur" items="${requestScope.formateur}">
                    <tr>
                        <td><c:out value="${formateur.idusers.firstName}"/></td>
                        <td><c:out value="${formateur.idusers.lastName}"/></td>
                        <td><c:out value="${formateur.idusers.email}"/></td>
                        <td><c:out value="${formateur.idusers.role}"/></td>
                        <td><c:out value="${formateur.idSpecialite.nomSpecialite}"/></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </section>




<script src="./js/app.js"></script>
</body>
</html>
