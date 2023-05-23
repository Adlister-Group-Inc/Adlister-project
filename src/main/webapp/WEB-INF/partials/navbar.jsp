<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container full-width nav-bar">
    <div class="row justify-center centered-navbar">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="column shrink adLister-logo">
            <a class="navbar-brand" href="http://localhost:8080/">Adlister</a>
        </div>
        <div class="row grow navbar-search-width justify-center align-right">
            <div class="column shrink navbar-search">
                <search class="row grow justify-right align-center">
                    <div class="row">
                        <form class="navbar-search-direction" action="/ads/search" method="POST">
                            <input class="search-bar" type="text" name="search" placeholder="Find Your New New">
                            <button class="search-btn" type="submit"><i class="fa-solid fa-magnifying-glass"></i>Search</button>
                        </form>
                    </div>
                </search>
            </div>
        </div>
        <c:if test="${empty user}">
            <div class="column justify-center align-center">
                <div class="row shrink justify-center centered-navbar">
                    <i class=" column shrink fa-solid fa-light fa-user"></i>
                    <a class="column login-logout shrink" href="/user/login">Login</a>
                </div>
            </div>
        </c:if>
        <c:if test="${not empty user}">
            <div class="column grow justify-center">
                <div class="row shrink justify-center centered-navbar">
                    <div class="column shrink justify-center">
                        <a class="login-logout" href="/user/profile">Profile</a>
                    </div>
                    <div class="column justify-center align-center">
                        <div class="row shrink justify-center centered-navbar">
                            <i class=" column shrink fa-solid fa-light fa-user"></i>
                            <a class="column login-logout shrink" href="/logout">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="dropdown">
            <button class="dropbtn">Categories</button>
            <div class="dropdown-content">
                <a href="/ads">View All Ads</a><br>
                <a href="/ads/category?category=community">Community</a><br>
                <a href="/ads/category?category=services">Services</a><br>
                <a href="/ads/category?category=housing">Housing</a><br>
                <a href="/ads/category?category=for_sale">For Sale</a><br>
                <a href="/ads/category?category=jobs">Jobs</a><br>
                <a href="/ads/category?category=gigs">Gigs</a><br>
                <a href="/ads/category?category=resumes">Resumes</a><br>
                <a href="/ads/category?category=personals">Personals</a><br>
                <a href="/ads/category?category=discussion_forums">Discussion Forums</a><br>
                <a href="/ads/category?category=events">Events</a><br>
            </div>
        </div>
    </div>
</div>

