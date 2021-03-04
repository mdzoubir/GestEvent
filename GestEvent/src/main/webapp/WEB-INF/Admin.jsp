<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 01/03/2021
  Time: 12:29
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <jsp:include page="menu.jsp" />

    <section>
        <div class="container">
            <button class="btn btn-primary"><a href="addAdmin" style="color: white; text-decoration: none">Ajouter Admin</a></button>

            <table id="table" border="1"  class="table table-bordered " style="margin-top: 20px">
                <tr>
                    <th>first name</th>
                    <th>last name</th>
                    <th>email</th>
                    <th>role</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                <c:forEach var="user" items="${requestScope.user}" >
                    <c:if test="${user.role.equals(requestScope.admin)}" >
                        <tr>
                            <td><c:out value="${user.firstName}"/></td>
                            <td><c:out value="${user.lastName}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.role}"/></td>
                            <td>
                                <form method="get" action="UpdateAdmin">
                                    <input value="${user.id}" type="hidden" name="id" class="id">
                                    <input type="submit" name="action" value="Update">
                                </form>
                            </td>
                            <td>
                                <form method="post" action="SupAdmin">
                                    <input value="${user.id}" type="hidden" name="id" class="id">
                                    <input type="submit" name="action" value="Delete">
                                </form>
                            </td>
                        </tr>

                    </c:if>
                </c:forEach>
            </table>
        </div>
    </section>

    <script src="./js/app.js"></script>
</body>
</html>
