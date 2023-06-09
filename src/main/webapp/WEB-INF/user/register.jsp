<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <c:if test="${usernameError == true}">
            <p style="color: red">Something went wrong with your username, please try again.</p>
        </c:if>
        <c:if test="${passwordError == true}">
            <p style="color: red">Something went wrong with your password, please try again.</p>
        </c:if>
        <c:if test="${emailError == true}">
            <p style="color: red">Something went wrong with your Email, please try again.</p>
        </c:if>
        <form action="/user/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value="${username}">
                <p>(Username must be more than 4 characters and less than 25)</p>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
                <p>(Password must be more than 8 characters and less than 20)</p>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" value="${email}">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>

</body>
</html>
