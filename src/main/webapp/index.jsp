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
            <div class="column align-right">
                <div class="sellerText">
                    <button id="seller-button">I am a Seller</button>
                </div>
                <div class="image-wrapper1">
                    <img src="css/img/dream_TradingCard (3).jpg">
                </div>
            </div>
            <div class="column">
                <div class="buyerText">
                    <button id="buyer-button">I am a buyer</button>
                </div>
                <div class="image-wrapper">
                    <img src="css/img/dream_TradingCard (8).jpg">
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
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
            <h6>"Web Devs"</h6>
        </div>
    </div>
    <div class="container">
        <div class="row justify-space-between">
            <div class="column">
                <p>Cynthia</p>
                <div class="image-wrapper">
                    <img src="css/img/cynthia.png">
                </div>
                <div>
                    <a href="https://www.linkedin.com/in/cynthia-v-nelson/">LinkedIn |</a>
                    <a href="https://github.com/CynCity17"> Github</a>
                </div>
                <p>Front-End Dev</p>
            </div>
            <div class="column">
                <p>John</p>
                <div class="image-wrapper">
                    <img src="css/img/John.jpg">
                </div>
                <div>
                    <a href="https://www.linkedin.com/in/john-buhr-918a8720a/">LinkedIn |</a>
                    <a href="https://github.com/Jbuhr92"> Github</a>
                </div>
                <p>Back-End Dev</p>
            </div>
            <div class="column">
                <p>Najee</p>
                <div class="image-wrapper">
                    <img src="/css/img/najee.jpeg">
                </div>
                <div>
                    <a href="https://www.linkedin.com/in/najeealeem/">LinkedIn |</a>
                    <a href="https://github.com/Naleem1"> Github</a>
                </div>
                <p>Front-End Dev</p>
            </div>
            <div class="column">
                <p>Ezra</p>
                <div class="image-wrapper">
                    <img src="css/img/Ezra.jpg">
                </div>
                <div>
                    <a href="https://www.linkedin.com/in/ezra-marama/">LinkedIn |</a>
                    <a href="https://github.com/Ez-Megalodon"> Github</a>
                </div>
                <p>Back-End Dev</p>
            </div>
        </div>
    </div>
</div>
<script src="js/index.js"></script>
</body>
</html>