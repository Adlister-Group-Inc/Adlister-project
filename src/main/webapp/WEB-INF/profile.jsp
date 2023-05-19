<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${user.username}!</h1>
    </div>
    <div>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6 ad-card" data-ad-id="${ad.id}">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <button class="edit">Edit</button>
                <button class="delete">Delete</button>
            </div>
        </c:forEach>
    </div>
<script src="/js/profile.js"></script>
</body>
</html>
