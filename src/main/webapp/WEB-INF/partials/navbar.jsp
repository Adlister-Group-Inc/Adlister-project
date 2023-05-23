<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container full-width">
        <div class="row justify-center">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="column shrink adLister-logo">
                <a class="navbar-brand" href="http://localhost:8080/">Adlister</a>
            </div>
            <div class="column shrink navbar-search">
                <form action="/search" method="POST">
                    <input type="text" name="search" placeholder="Find Your New New">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i>Search</button>
                </form>
            </div>
            <c:if test="${empty user}">
                <div class="column shrink justify-right">
                    <div class="fa-solid fa-user shrink"></div><div><a class="login-logout" href="/login">Login</a></div>
                </div>
            </c:if>
            <c:if test="${not empty user}">
                <div class="column shrink justify-center">
                    <a class="login-logout" href="/profile">Profile</a>
                </div>
                <div class="column shrink justify-center">
                    <i class="fa-light fa-user"></i><a class="login-logout" href="/logout">Logout</a>
                </div>
            </c:if>
            <div class="dropdown">
                <button class="dropbtn">Categories</button>
                <div class="dropdown-content">
                        <a href="/ads">View All Ads</a><br>
                        <a href="/category?category=community">Community</a><br>
                        <a href="/category?category=services">Services</a><br>
                        <a href="/category?category=housing">Housing</a><br>
                        <a href="/category?category=for_sale">For Sale</a><br>
                        <a href="/category?category=jobs">Jobs</a><br>
                        <a href="/category?category=gigs">Gigs</a><br>
                        <a href="/category?category=resumes">Resumes</a><br>
                        <a href="/category?category=personals">Personals</a><br>
                        <a href="/category?category=discussion_forums">Discussion Forums</a><br>
                        <a href="/category?category=events">Events</a><br>
                </div>
            </div>
        </div>

</div>
</nav>


