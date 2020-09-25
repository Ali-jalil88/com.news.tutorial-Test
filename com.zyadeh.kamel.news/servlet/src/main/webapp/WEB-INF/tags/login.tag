<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="khgkjgkjhgkjhgkj">
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/statics/tags/login_tag.css"/>">
</head>
<body>
<div class="flag">
    <div class="fronter">
        <form action="${pageContext.request.contextPath}/users" method="post">
            <div>
                <label for="username"></label>
                <input type="text" id="username" name="username" placeholder="username" required/>
            </div>

            <div>
                <label for="password"></label>
                <input type="password" id="password" name="password" placeholder="password" required/>
            </div>
            <input type="hidden" name="command" value="command_login">

            <div class="login_bttn">
                <input type="submit" name="login" value="Login">
            </div>

        </form>
    </div>
</div>
<div class="divider_div">
    <p class="divider">
        Avone is evaluated as my most unique Multi-Concept eCommerce Shopify Theme for shop online with clean and modern design.</p>
</div>
</body>
</html>