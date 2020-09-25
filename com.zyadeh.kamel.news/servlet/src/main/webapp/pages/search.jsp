<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title> search </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/search.css">
</head>
<body>
<tag:navigator/>
<div class="search">
    <form action="${pageContext.request.contextPath}/users" method="post">
        <input type="hidden" name="command" value="search_news_command"/>
                <input type="submit" name="search" value="Search"/>
            <input type="text" name="searching" placeholder="search..."/>

<div class="news-body">
    <div class="news">
        <c:forEach var="news" items="${sessionScope.filtered}" varStatus="i.<isindex>">
            <c:set var="count" value="${pageScope.count+1}"/>


            <div class="news-transition">
                <div class="container-part-3">
                        <%--                    <a href="news.jsp">--%>
                    <div class="part-3">
                        <a href="<c:url value="${pageContext.request.contextPath}/users?index=${count}&command=selected_news"/>">
                            <c:forEach var="url" items="${news.urls}">
                                <div class="img-wrapper">
                                    <img src="${url}">
                                </div>
                            </c:forEach>
                        </a>
                    </div>
                        <%--                    </a>--%>
                    <div class="textarea">
                        <label>
                            <p class="title">${sessionScope.news[param.index-1].title} ${news.title}</p>
                        </label>
                        <label>
                            <p class="short_text">${sessionScope.news[param.index-1].shortText} ${news.shortText}</p>
                        </label>
                        <label>
                            <p class="short_text">${sessionScope.news[param.index-1].fullText} ${news.fullText}</p>
                        </label>
                    </div>

                </div>
            </div>
<%--            <a href="/pages/news.jsp?index=${count}&command=selected_news"></a>--%>
        </c:forEach>
    </div>
</div>
<!-- <div class="create_div">
    <a class="create" href="${pageContext.request.contextPath}/pages/create.jsp">Create</a>
    </div>-->
    </form>
</div>
</body>
</html>
