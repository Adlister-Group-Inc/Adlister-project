<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Creat an Ad!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="page-wrapper">
        <div class="container">
            <div class="row">
                <div class="column">
                    <h1>Create a new Ad</h1>
                   <c:if test="${titleError == true}">
                    <p style="color: deeppink">Title must be less than 70 characters</p>
                    </c:if>
                    <c:if test="${descriptionError == true}">
                        <p style="color: deeppink">Description must be less than 255 characters</p>
                    </c:if>
                    <form action="/ads/create" method="post">
                    <div class="form-group">
                    <label for="title">Title</label>
                    <input id="title" name="title" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                    <label for="description">Description</label>
                    <textarea id="description" name="description" class="form-control" type="text"></textarea>
                    </div>
                    <input type="submit" class="btn btn-block btn-primary">
                    </form>
                </div>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <div>
                <label>Community</label>
                <input name="category" value="1" type="checkbox">
                <label>Services</label>
                <input name="category" value="2" type="checkbox">
                <label>housing</label>
                <input name="category" value="3" type="checkbox">
                <label>For Sale</label>
                <input name="category" value="4" type="checkbox">
                <label>Jobs</label>
                <input name="category" value="5" type="checkbox">
                <label>Gigs</label>
                <input name="category" value="6" type="checkbox">
                <label>Resumes</label>
                <input name="category" value="7" type="checkbox">
                <label>Personals</label>
                <input name="category" value="8" type="checkbox">
                <label>Discussion Forums</label>
                <input name="category" value="9" type="checkbox">
                <label>Events</label>
                <input name="category" value="10" type="checkbox">
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>