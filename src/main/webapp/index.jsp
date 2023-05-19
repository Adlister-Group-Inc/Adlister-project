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
    <div class="container">
        <div class="row justify-center">
                <h1>Welcome to Adlister!</h1>
        </div>
        <div class="row justify-center">
                <h3>Pre-Owned is the New New this year!</h3>
        </div>
        <div>
            <a href="/register">Register</a>
        </div>
    </div>
    <div class="container">
        <div class="row justify-center">
            <h2>Our Team</h2>
        </div>
        <div class="row justify-center">
            <h6>"The CodeCrafters"</h6>
        </div>
        <div class="container">
            <div class="row">
                <div class="column">Cynthia<img src="HeroBackground.png"></div>
                <div class="column">John</div>
                <div class="column">Najee</div>
                <div class="column">Ezra</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
