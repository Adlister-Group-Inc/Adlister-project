<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="page-wrapper">
    <div class="container grow">
        <div class="row justify-center">
                <h1>Welcome to Adlister!</h1>
        </div>
        <div class="row justify-center">
                <h3>Pre-Owned is the New New this year!</h3>
        </div>
        <div>
            <button>
                <a href="/register">Register</a>
            </button>
        </div>
    </div>
    <div class="container justify-end">
        <div class="row justify-center">
            <h2>Our Team</h2>
        </div>
        <div class="row justify-center">
            <h6>"The CodeCrafters"</h6>
        </div>
        <div class="container">
            <div class="row">
                <div class="column">Cynthia<img src=""></div>
                <div class="column">John<img src=""></div>
                <div class="column">Najee<img src="1644340903868.jpeg"></div>
                <div class="column">Ezra<img src=""></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
