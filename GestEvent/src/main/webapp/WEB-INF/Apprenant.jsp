<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 01/03/2021
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/admin.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="menu.jsp" />
<section>
    <div class="container">
        <button class="btn btn-primary"><a href="AddApprenant" style="color: white; text-decoration: none">Ajouter Apprenant</a></button>
        <table id="table" border="1"  class="table table-bordered " style="margin-top: 20px">
            <tr>
                <th>first name</th>
                <th>last name</th>
                <th>email</th>
                <th>role</th>
                <th>specialite</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            <c:forEach var="appr" items="${requestScope.apprenant}" >
                <tr>
                    <td><c:out value="${appr.idUsers.firstName}"/></td>
                    <td><c:out value="${appr.idUsers.lastName}"/></td>
                    <td><c:out value="${appr.idUsers.email}"/></td>
                    <td><c:out value="${appr.idUsers.role}"/></td>
                    <td><c:out value="${appr.idSpecialite.nomSpecialite}"/></td>
                    <td>
                        <form method="get" action="UpdateApprenantr">
                            <input value="${appr.idUsers.id}" type="hidden" name="idUser" class="id">
                            <input value="${appr.idApprenant}" type="hidden" name="idApprenant" class="id">
                            <input type="submit" name="action" value="Update">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="SupApprenant">
                            <input value="${appr.idUsers.id}" type="hidden" name="id" class="id">
                            <input value="${appr.idApprenant}" type="hidden" name="idAppr" class="id">
                            <input type="submit" name="action" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>

<script src="./js/app.js"></script>
</body>
</html>
