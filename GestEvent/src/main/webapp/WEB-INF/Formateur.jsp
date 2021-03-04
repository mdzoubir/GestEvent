<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 01/03/2021
  Time: 13:18
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
        <button class="btn btn-primary"><a href="AddFormateur" style="color: white; text-decoration: none">Ajouter Formateur</a></button>
        <table id="table" border="1"  class="table table-bordered " style="margin-top: 20px">
            <tr>
                <th>first name</th>
                <th>last name</th>
                <th>email</th>
                <th>role</th>
                <th>specialite</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="formateur" items="${requestScope.formateur}">
                <tr>
                    <td><c:out value="${formateur.idusers.firstName}"/></td>
                    <td><c:out value="${formateur.idusers.lastName}"/></td>
                    <td><c:out value="${formateur.idusers.email}"/></td>
                    <td><c:out value="${formateur.idusers.role}"/></td>
                    <td><c:out value="${formateur.idSpecialite.nomSpecialite}"/></td>
                    <td>
                        <form method="get" action="UpdateFormateur">
                            <input value="${formateur.idusers.id}" type="hidden" name="idUser" class="id">
                            <input value="${formateur.idFormatur}" type="hidden" name="idFormateur" class="id">
                            <input type="submit" name="action" value="Update">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="SupFormateur">
                            <input value="${formateur.idusers.id}" type="hidden" name="id" class="id">
                            <input value="${formateur.idFormatur}" type="hidden" name="idFormateur" class="id">
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
