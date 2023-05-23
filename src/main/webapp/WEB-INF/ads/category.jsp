<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="../partials/head.jsp">
    <jsp:param name="title" value="Ads by Category" />
  </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="page-wrapper">
  <div class="container">
    <div class="row">
      <div class="column">

        <c:if test="${empty category}">
          <h1>Here Are all the ads!</h1>
        </c:if>

        <c:if test="${not empty category}">
          <h1>You are searching for ${category}</h1>
        </c:if>
        <br>
        <c:if test="${results != null}">
          <c:forEach var="ad" items="${results}">
            <h2><a href="/ads/adDetails?id=${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>
          </c:forEach>
        </c:if>

      </div>
    </div>
  </div>
</div>
</body>

</html>
