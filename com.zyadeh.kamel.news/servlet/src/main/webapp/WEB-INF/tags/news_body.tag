<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/statics/tags/news_body.css"/>">
</head>
<body>
<div class="news-body">
    <div class="news">
        
        <c:forEach var="news" items="${sessionScope.news}" varStatus="i.<isindex>">
            <c:set var="count" value="${pageScope.count+1}"/>
            <a href="/pages/news.jsp?index=${count}">
                <div class="news-transition">
                        <%--<div class="part-1">--%>
                        <%--<ul>--%>
                        <%--<li>${news.title}</li>--%>
                        <%--<li>${news.publishedIn}</li>--%>
                        <%--<li>${news.createdIn}</li>--%>
                        <%--<li hidden>${news.id}</li>--%>
                        <%--</ul>--%>
                        <%--</div>--%>
                        <%--<div class="part-2">--%>
                        <%--<ul>--%>
                        <%--<li>${news.shortText}</li>--%>
                        <%--<li>${news.fullText}</li>--%>
                        <%--<li>${news.author.name}-${news.author.lastName}</li>--%>
                        <%--</ul>--%>
                        <%--</div>--%>
                    <div class="container-part-3">
                        <div>
                            <div class="part-3">
                                <c:forEach var="url" items="${news.urls}">
                                    <div class="img-wrapper">
                                        <img src="${url}">
                                    </div>
                                </c:forEach>
                            </div>
                            <h3>${news.title}</h3>
                        </div>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
<div class="create_div">
    <a class="create" href="/pages/create.jsp">Create</a>
</div>
</body>
</html>