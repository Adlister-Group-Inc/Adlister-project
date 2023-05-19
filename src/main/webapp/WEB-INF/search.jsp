<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Ads</title>
    <link rel="stylesheet" href="/css/resets.css">
    <link rel="stylesheet" href="/css/layout.css">
</head>
<body>
<div class="page-wrapper">
<div class="container">
    <div class="row">
        <div class="column">

            <c:if test="${empty search}">
                <h1>Here Are all the ads!</h1>
            </c:if>

            <c:if test="${not empty search}">
                <h1>You are searching for ${search}"</h1>
            </c:if>

            <form action="/search" method="POST">
                <input type="text" name="search" placeholder="Search">
                <button type="submit">Search</button>
            </form>

            <c:if test="${results != null}">
                <c:forEach var="ad" items="${results}">
                    <h2><a href="ads/adDetails?id=${ad.id}">${ad.title}</a></h2>
                    <p>${ad.description}</p>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
</div>
</body>
</html>