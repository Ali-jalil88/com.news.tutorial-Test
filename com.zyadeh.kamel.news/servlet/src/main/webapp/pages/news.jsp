<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="../statics/news.css">
</head>
<body>

<tag:navigator/>

<div class="fetch_body">

    <div class="news_body">
        <%--<form action="${pageContext.request.contextPath}/users" method="post">--%>
        <form action="${pageContext.request.contextPath}/users" method="post">
            <%--<input type="hidden" name="id" ${sessionScope.news[param.index-1].getId()}>--%>
            <label>
                <textarea class="id" name="id" hidden>${sessionScope.news[param.index-1].id}</textarea>
            </label>
            <input type="hidden" name="command" value="news_update_command"/>

            <label>
                <textarea class="title" name="title" contenteditable="true" aria-multiline="false" autocomplete="off"
                          rows="1">${sessionScope.news[param.index-1].title}</textarea>
            </label>
            <%--<div class="title">--%>
            <%--${sessionScope.news[param.index-1].title}--%>
            <%--</div>--%>
            <label>
                 <textarea class="short_text" name="short_text" contenteditable="true" autocomplete="off"
                           rows="1">${sessionScope.news[param.index-1].shortText}</textarea>
            </label>
            <%--<div class="short_text">--%>
            <%--${sessionScope.news[param.index-1].shortText}--%>
            <%--</div>--%>
            <label>
                 <textarea class="full_text" name="full_text" contenteditable="true" autocomplete="off"
                 >${sessionScope.news[param.index-1].fullText}</textarea>
            </label>
            <%--<div class="full_text">--%>
            <%--${sessionScope.news[param.index-1].fullText}--%>
            <%--</div>--%>
            <div class="sub_section">
                <div class="left">
                    <label>
                         <textarea class="published_in" name="published_in" contenteditable="true" autocomplete="off"
                                   rows="1"
                         >${sessionScope.news[param.index-1].publishedIn}</textarea>
                    </label>
                    <%--<div class="published_in">--%>
                    <%--${sessionScope.news[param.index-1].publishedIn}--%>
                    <%--</div>--%>
                    <label>
                         <textarea class="author" name="author" contenteditable="true" autocomplete="off" rows="1">
                             ${sessionScope.news[param.index-1].author.name} ${sessionScope.news[param.index-1].author.lastName}</textarea>
                    </label>
                    <%--<div class="author">--%>
                    <%--${sessionScope.news[param.index-1].author.name} ${sessionScope.news[param.index-1].author.lastName}--%>
                    <%--</div>--%>
                </div>
                <label>
                    <textarea class="created_in" name="created_in" contenteditable="true" autocomplete="off" rows="1"
                    >${sessionScope.news[param.index-1].createdIn}</textarea>
                </label>
                <%--<div class="created_in">--%>
                <%--${sessionScope.news[param.index-1].createdIn}--%>
                <%--</div>--%>
            </div>
            <div>
                <input type="submit" name="save" value="Save"/>
            </div>
            <%--<div class="myButtons">--%>
            <%----%>
            <%--</div>--%>
        </form>
        <%--</form>--%>
    </div>

</div>
</body>
</html>
