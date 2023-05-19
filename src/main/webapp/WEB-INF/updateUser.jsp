<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Update User" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <div class="row">
        <div class="column">
            <form action="/updateUser" method="post">
                <h2>Update User Information</h2>
                <p>Warning! these changes cannot be undone.</p>
                <br>
                <label for="updateUsername">Change Username:</label>
                <input type="text" name="updateUsername" id="updateUsername" value="${user.username}">
                <label for="updateEmail">Change Email:</label>
                <input type="text" name="updateEmail" id="updateEmail" value="${user.email}">
                <label for="updatePassword">Change Password:</label>
                <input type="password" name="updatePassword" id="updatePassword" placeholder="New Password">
                <label for="updatePasswordConfirm">Confirm Password:</label>
                <input type="password" name="updatePasswordConfirm" id="updatePasswordConfirm" placeholder="Confirm New Password">
                <button type="submit">Submit Changes</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
