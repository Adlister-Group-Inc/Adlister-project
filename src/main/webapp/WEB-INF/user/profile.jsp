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
<div class="page-wrapper">
    <div class="container">
        <h1>Welcome, ${user.username}!</h1>
        <button><a href="/ads/create">Create Ad!</a></button>
        <button><a href="/user/updateUser">Edit profile</a></button>
        <div>
            <h2>Your ads:</h2>
            <br>
        <c:forEach var="ad" items="${ads}">
            <div class="ad-card" data-ad-id="${ad.id}">
                <h2 class="ad-title"><a href="/ads/adDetails?id=${ad.id}">${ad.title}</a></h2>
                <p class="ad-description">${ad.description}</p>
                <button class="edit">Edit</button>
                <button class="delete">Delete</button>
            </div>
            <form action="/user/profile" method="post" class="edit-form" style="display:none">
                <input name="id" value="${ad.id}" style="display: none">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input value="${ad.title}" id="title" name="title" class="form-control" type="text">
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input value="${ad.description}" id="description" name="description" class="form-control" type="text">
                </div>
                <input type="submit" class="btn btn-block btn-primary submit">
            </form>
            <form action="/ads/adDelete" method="post" class="delete-form" style="display:none">
                <input name="id" value="${ad.id}" style="display: none">
                <div class="form-group">
                    <label for="title">Are you sure you want to delete ${ad.title}</label>
                </div>

                <input type="submit" class="btn btn-block btn-primary submitDelete">
            </form>
        </c:forEach>

        </div>
    </div>
</div>
<script src="/js/profile.js"></script>
</body>
</html>