<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/admin.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- email or password incorrect -->
        <c:set var = "message"  value = "${requestScope.message}"/>
        <c:if test = "${message != null && !message.isEmpty()}">
            <p class="alert alert-danger"><c:out value = "${message}"/><p>
        </c:if>
        <!-- Icon -->
        <div class="fadeIn first">
            <img  id="icon"/>
        </div>

        <!-- Login Form -->
        <form action="login" method="post">
            <input type="text" id="login" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="fadeIn second" name="email" placeholder="login">
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In" name="login">
        </form>

        <!-- Remind Passowrd -->
<%--        <div id="formFooter">--%>
<%--            <a class="underlineHover" href="#">Forgot Password?</a>--%>
<%--        </div>--%>

    </div>
</div>
</body>
</html>