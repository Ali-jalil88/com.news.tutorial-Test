<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="../statics/home.css">
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.user != null}">
        <tag:navigator/>
    </c:when>
    <c:otherwise>
        <tag:welcome_nav/>
    </c:otherwise>
</c:choose>
<tag:header/>
    <c:if test="${sessionScope.user != null}">
        <tag:news_body/>
    </c:if>
<tag:fotter/>
</body>
</html>