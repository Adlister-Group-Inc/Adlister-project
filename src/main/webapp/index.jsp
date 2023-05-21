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
    </div>
    <div class="container grow justify-center">
        <div class="row">
            <div class="column">I am a Seller<img src="css/img/dream_TradingCard (3).jpg"></div>
            <div class="column">I am a buyer<img src="css/img/dream_TradingCard (8).jpg"></div>
        </div>
        <div>
            <button>
                <a href="/register">Register</a>
            </button>
        </div>
    </div>
    <div class="container grow justify-space-between">
        <div class="row">
            <div class="column">Box1</div>
            <div class="column">Box2</div>
        </div>
    </div>
    <div class="container justify-end">
        <div class="row justify-center">
            <h2>Our Team</h2>
        </div>
        <div class="row justify-center">
            <h6>"Web Devs"</h6>
        </div>
        <div class="container">
            <div class="row">
                <div class="column">Cynthia<img src="css/img/cynthia.png"><a href="https://www.linkedin.com/in/cynthia-v-nelson/">LinkedIn</a>|<a href="https://github.com/CynCity17">Github</a>Front-end Dev</div>
                <div class="column">John<img src="css/img/John.jpg"><a href="https://www.linkedin.com/in/john-buhr-918a8720a/">LinkedIn</a>|<a href="https://github.com/Jbuhr92">Github</a>Back-in Dev</div>
                <div class="column">Najee<img src="/css/img/najee.jpeg"><a href="https://www.linkedin.com/in/najeealeem/">LinkedIn</a>|<a href="https://github.com/Naleem1">Github</a>Front-end Dev</div>
                <div class="column">Ezra<img src="css/img/Ezra.jpg"><a href="https://www.linkedin.com/in/ezra-marama/">LinkedIn</a>|<a href="https://github.com/Ez-Megalodon">Github</a>Back-end Dev</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>