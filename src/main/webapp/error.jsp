<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<%-- Retrieve the error code and exception from the request --%>
<%@ page isErrorPage="true" %>
<% Integer errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code"); %>
<% Exception newException = (Exception) request.getAttribute("javax.servlet.error.exception"); %>

<%-- Set custom error messages based on the error code or exception --%>
<% String errorMessage = ""; %>
<% if (errorCode != null) { %>
<% if (errorCode == 404) { %>
<% errorMessage = "Page not found. (404)"; %>
<% } else if (errorCode == 403) { %>
<% errorMessage = "Access forbidden. (403)"; %>
<% } else if (errorCode == 500) { %>
<% errorMessage = "Internal server error. (500)"; %>
<% } else { %>
<% errorMessage = "An error occurred."; %>
<% } %>
<% } else if (newException != null) { %>
<% errorMessage = "An exception occurred: " + newException.getMessage(); %>
<% } %>

<%-- Display the error message --%>
<h1>Error</h1>
<h3><%= errorMessage %></h3>
<br>
<br>
<p>Please go <a href="http://localhost:8080/">Home</a></p>
</body>
</html>