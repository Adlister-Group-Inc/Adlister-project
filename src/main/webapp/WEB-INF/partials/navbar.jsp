<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container full-width">
        <div class="row">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="http://localhost:8080/">Adlister</a>
                </div>
            </div>
        <div class="row d-flex">
            <div class="column d-flex">
                <form action="/search" method="POST">
                    <input type="text" name="search" placeholder="Search">
                    <button type="submit">Search</button>
                </form>
            </div>
            <div class="align-items-end">
                <c:if test="${empty user}">
                    <a href="/login">Login</a>
                </c:if>
                <c:if test="${not empty user}">
                    <a href="/profile">Profile</a>
                    <a href="/logout">Logout</a>
                </c:if>
            </div>
        </div>

</div>
</nav>


