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
                    <div class="wavy">
                        <span style="--i:1">A</span>
                        <span style="--i:2">D</span>
                        <div class="spacer"><p>   </p></div>
                        <span style="--i:3">L</span>
                        <span style="--i:4">i</span>
                        <span style="--i:5">s</span>
                        <span style="--i:6">t</span>
                        <span style="--i:7">e</span>
                        <span style="--i:8">r</span>
                    </div>
                </div>
                <div class="row subheader grow justify-center">
                        <h2 class="text-shadow"> <- Preowned is the NEW NEW this year -> </h2>
                </div>
            </div>
            <div class="container justify-center">
                <div class="row justify-space-between">
                    <div class="column shrink">
                        <div class="sellerText">
                            <button class="btns" id="seller-button">I am a Seller</button>
                        </div>
                    </div>
                    <div class="column shrink">
                        <div class="buyerText">
                            <button class="btns" id="buyer-button">I am a buyer</button>
                        </div>
                    </div>
                </div>
                <div class="row gap-10 justify-center">
                    <div class="image-wrapper1">
                        <img src="css/img/GetPaidNT.png">
                    </div>
                    <div class="image-wrapper">
                        <img src="css/img/BuyerInfo.png">
                    </div>
                </div>
            </div>
            <div class="container gap-20">
                <div class="row justify-center">
                    <button id="register-button">
                        <a href="/register">Register</a>
                    </button>
                </div>
            </div>
            <div class="container justify-end">
                <div class="row justify-center">
                    <h2>Our Team</h2>
                </div>
                <div class="row justify-center">
                    <h3>"Web Devs"</h3>
                </div>
            </div>
            <div class="container justify-space-between">
                <div class="row dev">
                    <div class="column">
                        <p>Cynthia</p>
                    <div class="image-wrapper-devs">
                        <img src="css/img/hishairdown.gif" class="dev1" alt="Cynthia Front End Dev">
                    </div>
                    <div class="socialLinks">
                        <i class="fa-brands fa-linkedin"></i><a href="https://www.linkedin.com/in/cynthia-v-nelson/">LinkedIn |</a>
                        <i class="fa-brands fa-github"></i><a href="https://github.com/CynCity17"> Github</a>
                    </div>
                        <p>Front-End Dev</p>
                    </div>
                    <div class="column">
                        <p>John</p>
                    <div class="image-wrapper-devs">
                        <img src="css/img/DevJohn.jpg" class="dev2" alt="John Back End Dev">
                    </div>
                    <div class="socialLinks">
                        <i class="fa-brands fa-linkedin"></i><a href="https://www.linkedin.com/in/john-buhr-918a8720a/">LinkedIn |</a>
                        <i class="fa-brands fa-github"></i><a href="https://github.com/Jbuhr92"> Github</a>
                    </div>
                        <p>Back-End Dev</p>
                    </div>
                    <div class="column">
                        <p>Najee</p>
                    <div class="image-wrapper-devs">
                        <img src="/css/img/DevNajee.jpeg" class="dev3" alt="Najee Front End Dev">
                    </div>
                    <div class="socialLinks">
                        <i class="fa-brands fa-linkedin"></i><a href="https://www.linkedin.com/in/najeealeem/">LinkedIn |</a>
                        <i class="fa-brands fa-github"></i> <a href="https://github.com/Naleem1"> Github</a>
                    </div>
                        <p>Front-End Dev</p>
                    </div>
                    <div class="column">
                        <p>Ezra</p>
                    <div class="image-wrapper-devs">
                        <img src="css/img/DevEzra.jpg" class="dev4" alt="Ezra Back End Dev">
                    </div>
                    <div class="socialLinks">
                        <i class="fa-brands fa-linkedin"></i><a href="https://www.linkedin.com/in/ezra-marama/">LinkedIn |</a>
                        <i class="fa-brands fa-github"></i><a href="https://github.com/Ez-Megalodon"> Github</a>
                    </div>
                        <p>Back-End Dev</p>
                    </div>
                </div>
            </div>
        </div>
<script src="js/index.js"></script>
</body>
</html>